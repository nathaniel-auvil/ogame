package us.nauvil.ogame;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlayerFileLoader extends FileLoader {

	public PlayerFileLoader(String server) throws MalformedURLException {
		super(new URL("https://" + server + ".ogame.gameforge.com/api/players.xml"));
	}

	@Override
	protected void process(Document document) throws MalformedURLException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer dayId = Integer.parseInt(format.format(new Date(Long.parseLong(document.getDocumentElement().getAttribute("timestamp") + "000"))));

		NodeList nList = document.getElementsByTagName("player");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				Player p = new Player();
				p.setId(Integer.parseInt(eElement.getAttribute("id")));
				p.setName(eElement.getAttribute("name"));
				p.setStatus(eElement.getAttribute("status"));
				p.setAlliance((eElement.getAttribute("alliance").trim().length() == 0) ? null : Integer.parseInt(eElement.getAttribute("alliance")));
				p.setDayId(dayId);

				PlayerDao playerDao = new PlayerDao();
				playerDao.insert(p);

				System.out.println(p);
			}
		}
	}

}
