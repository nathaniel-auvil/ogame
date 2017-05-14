package us.nauvil.ogame;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class PlayerFileLoaderTest {

	@Test
	public void fetchURL() throws IOException, ParserConfigurationException, SAXException {
		FileLoader f = new PlayerFileLoader("s136-us");
		f.readXml();

	}
}
