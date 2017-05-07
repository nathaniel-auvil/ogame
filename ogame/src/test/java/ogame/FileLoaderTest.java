package ogame;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import us.nauvil.ogame.FileLoader;

public class FileLoaderTest {

	@Test
	public void fetchURL() throws IOException, ParserConfigurationException, SAXException {

		URL url = new URL("https://s136-us.ogame.gameforge.com/api/players.xml");

		FileLoader f = new FileLoader(url);
		f.readXml();

	}
}
