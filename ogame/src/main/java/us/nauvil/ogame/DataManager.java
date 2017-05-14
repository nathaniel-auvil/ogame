package us.nauvil.ogame;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import us.nauvil.ogame.db.PlayerDao;

public class DataManager {

	public void loadApiData() throws ParserConfigurationException, SAXException, IOException, SQLException {

		PlayerFileLoader playerFileLoader = new PlayerFileLoader("s136-us");
		playerFileLoader.readXml();

		for (Player p : playerFileLoader.getPlayers()) {
			PlayerDao playerDao = new PlayerDao();
			playerDao.insert(p);
		}

	}
}
