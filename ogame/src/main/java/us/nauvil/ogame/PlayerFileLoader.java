package us.nauvil.ogame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PlayerFileLoader extends FileLoader {

	private String server;

	public PlayerFileLoader(String server) throws MalformedURLException {
		// super(new
		// URL("https://s136-us.ogame.gameforge.com/api/players.xml"));
		super(new URL("https://" + server + ".ogame.gameforge.com/api/players.xml"));
		this.server = server;
	}

	@Override
	protected void process(Document document) throws MalformedURLException {

		// System.out.println("timestamp: " +
		// document.getDocumentElement().getAttribute("timestamp"));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer dayId = Integer.parseInt(format.format(new Date(Long.parseLong(document.getDocumentElement().getAttribute("timestamp") + "000"))));

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String insertTableSQL = "INSERT INTO players" + "(ID, NAME, STATUS, ALLIANCE, DAYID) VALUES" + "(?,?,?,?,?)";
		String insertScoreSQL = "INSERT INTO scores" + "(playerId, dayId, total, economy, research, military, militaryBuilt, militaryDestroyed, militaryLost, militaryShips, honor) VALUES" + "(?,?,?,?,?)";

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "viper21")) {
			c.setAutoCommit(true);
			System.out.println("Opened database successfully");

			NodeList nList = document.getElementsByTagName("player");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Integer id = Integer.parseInt(eElement.getAttribute("id"));
					String name = eElement.getAttribute("name");
					String status = eElement.getAttribute("status");
					Integer alliance = (eElement.getAttribute("alliance").trim().length() == 0) ? null : Integer.parseInt(eElement.getAttribute("alliance"));

					// System.out.print("id: " + eElement.getAttribute("id"));
					// System.out.print("\tname: " +
					// eElement.getAttribute("name"));
					// System.out.print("\t\tstatus : " +
					// eElement.getAttribute("status"));
					// System.out.println("\talliance : " +
					// eElement.getAttribute("alliance"));

					// System.out.println("alliance : " +
					// eElement.getElementsByTagName("alliance").item(0).getTextContent());

					try (PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL)) {
						preparedStatement.setInt(1, id);
						preparedStatement.setString(2, name);
						preparedStatement.setString(3, status);
						if (alliance != null) {
							preparedStatement.setInt(4, alliance);
						} else {
							preparedStatement.setNull(4, Types.INTEGER);
						}
						preparedStatement.setInt(5, dayId);

						preparedStatement.executeUpdate();
					} catch (SQLException s) {
						if (s.getSQLState().equals("23000")) {
							System.out.println("duplicate key");
						} else {
							s.printStackTrace();
						}
					}

					try {
						ScoreFileLoader score = new ScoreFileLoader(this.server, id);
						score.readXml();
					} catch (FileNotFoundException f) {
						System.out.println(f.getMessage());
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
