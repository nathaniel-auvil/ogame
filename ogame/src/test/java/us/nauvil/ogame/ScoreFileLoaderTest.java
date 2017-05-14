package us.nauvil.ogame;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ScoreFileLoaderTest {

	@Test
	public void fetchURL() throws IOException, ParserConfigurationException, SAXException {
		FileLoader f = new ScoreFileLoader("s136-us", 104946);
		f.readXml();

	}
}
