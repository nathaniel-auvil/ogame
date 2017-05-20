package us.nauvil.ogame;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class DataManagerTest {

	@Test
	public void loadData() throws ParserConfigurationException, SAXException, IOException, SQLException {
		DataManager d = new DataManager();
		d.loadApiData();
	}
}
