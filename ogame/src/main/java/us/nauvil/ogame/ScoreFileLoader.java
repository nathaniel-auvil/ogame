package us.nauvil.ogame;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ScoreFileLoader extends FileLoader {

	private Integer playerId;

	public ScoreFileLoader(String server, Integer playerId) throws MalformedURLException {
		super(new URL("https://" + server + ".ogame.gameforge.com/api/playerData.xml?id=" + playerId));
		this.playerId = playerId;
		System.out.println(playerId);
	}

	@Override
	protected void process(Document document) {

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

		String insertScoreSQL = "INSERT INTO scores" + "(playerId, dayId, total, economy, research, military, militaryBuilt, militaryDestroyed, militaryLost, militaryShips, honor) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "viper21")) {
			c.setAutoCommit(true);
			System.out.println("Opened database successfully");

			NodeList nList = document.getElementsByTagName("position");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Integer score = Integer.parseInt(eElement.getAttribute("score"));
					Integer type = Integer.parseInt(eElement.getAttribute("type"));

					Integer rank = Integer.parseInt(eElement.getTextContent());

					try (PreparedStatement preparedStatement = c.prepareStatement(insertScoreSQL)) {
						preparedStatement.setInt(1, this.playerId);
						preparedStatement.setInt(2, dayId);

						switch (type) {
						case 0:
							preparedStatement.setInt(3, score);
							break;
						case 1:
							preparedStatement.setInt(4, score);
							break;
						case 2:
							preparedStatement.setInt(5, score);
							break;
						case 3:
							preparedStatement.setInt(6, score);
							Integer ships = (eElement.getAttribute("ships").length() == 0) ? null : Integer.parseInt(eElement.getAttribute("ships"));
							if (ships == null) {
								preparedStatement.setNull(6, Types.INTEGER);
							} else {
								preparedStatement.setInt(10, ships);
							}
							break;
						case 4:
							preparedStatement.setInt(7, score);
							break;
						case 5:
							preparedStatement.setInt(8, score);
							break;
						case 6:
							preparedStatement.setInt(9, score);
							break;
						case 7:
							preparedStatement.setInt(11, score);
							break;
						}

						preparedStatement.executeUpdate();
					} catch (SQLException s) {
						if (s.getSQLState().equals("23000")) {
							System.out.println("duplicate key");
						} else {
							s.printStackTrace();
						}
					}

					// eElement.getElementsByTagName("alliance").item(0).getTextContent());

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
