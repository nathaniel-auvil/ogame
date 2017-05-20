package us.nauvil.ogame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class FileLoader {

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
		} catch (FileNotFoundException f) {
			System.out.println("not found: " + this.url.toString());
		}

		return s.toString();
	}

	public void readXml() throws ParserConfigurationException, SAXException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc;
		try {
			doc = dBuilder.parse(this.url.openStream());

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			this.process(doc);

		} catch (IOException e) {
			System.out.println("not found: " + this.url.toString());
		}
	}

	abstract protected void process(Document docuemnt) throws MalformedURLException;
}
