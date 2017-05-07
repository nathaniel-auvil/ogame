package us.nauvil.ogame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileLoader {

	private URL url;

	public FileLoader(URL url) {
		this.url = url;
	}

	public String read() throws IOException {

		StringBuilder s = new StringBuilder(1024);

		try (BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				s.append(inputLine);
		}

		return s.toString();
	}

	public void readXml() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(this.url.openStream());
		

		// optional, but recommended
		// read this -
		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("player");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			//System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.print("id: " + eElement.getAttribute("id"));
				System.out.print("\tname: " + eElement.getAttribute("name"));
				System.out.print("\t\tstatus : " + eElement.getAttribute("status"));
				System.out.println("\talliance : " + eElement.getAttribute("alliance"));
				
				//System.out.println("alliance : " + eElement.getElementsByTagName("alliance").item(0).getTextContent());
			}
		}
	}
}
