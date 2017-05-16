package us.nauvil.ogame;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import us.nauvil.ogame.db.PlayerDao;
import us.nauvil.ogame.db.ScoreDao;

public class DataManager {

	private String server = "s136-us";

	public void loadApiData() throws ParserConfigurationException, SAXException, IOException, SQLException {

		PlayerFileLoader playerFileLoader = new PlayerFileLoader(server);
		playerFileLoader.readXml();

		for (Player p : playerFileLoader.getPlayers()) {
			PlayerDao playerDao = new PlayerDao();
			playerDao.insert(p);

			ScoreFileLoader scoreFileLoader = new ScoreFileLoader(server, p.getId());
			scoreFileLoader.readXml();
			ScoreDao scoreDao = new ScoreDao();
			scoreDao.insert(scoreFileLoader.getS());
		}
	}
}
