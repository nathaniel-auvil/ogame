package us.nauvil.ogame;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import us.nauvil.ogame.FileLoader;
import us.nauvil.ogame.PlayerFileLoader;

public class PlayerFileLoaderTest {

	@Test
	public void fetchURL() throws IOException, ParserConfigurationException, SAXException {

		URL url = new URL("https://s136-us.ogame.gameforge.com/api/players.xml");

		FileLoader f = new PlayerFileLoader("s136-us");
		f.readXml();

	}
}
