package us.nauvil.ogame;

import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlayerFileLoader extends FileLoader {

	public PlayerFileLoader(String server) throws MalformedURLException {
		// super(new
		// URL("https://s136-us.ogame.gameforge.com/api/players.xml"));
		super(new URL("https://" + server + ".ogame.gameforge.com/api/players.xml"));
	}

	@Override
	protected void process(Document document) {

		NodeList nList = document.getElementsByTagName("player");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			// System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.print("id: " + eElement.getAttribute("id"));
				System.out.print("\tname: " + eElement.getAttribute("name"));
				System.out.print("\t\tstatus : " + eElement.getAttribute("status"));
				System.out.println("\talliance : " + eElement.getAttribute("alliance"));

				// System.out.println("alliance : " +
				// eElement.getElementsByTagName("alliance").item(0).getTextContent());
			}
		}

	}

}
