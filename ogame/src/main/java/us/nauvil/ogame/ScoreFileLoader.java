package us.nauvil.ogame;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ScoreFileLoader extends FileLoader {

	private Integer playerId;
	private List<Score> scores;

	public ScoreFileLoader(String server, Integer playerId) throws MalformedURLException {
		super(new URL("https://" + server + ".ogame.gameforge.com/api/playerData.xml?id=" + playerId));
		this.playerId = playerId;

		this.scores = new ArrayList<Score>(4096);
	}

	@Override
	protected void process(Document document) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer dayId = Integer.parseInt(format.format(new Date(Long.parseLong(document.getDocumentElement().getAttribute("timestamp") + "000"))));

		Score s = new Score();
		s.setDayId(dayId);
		s.setPlayerId(playerId);

		NodeList nList = document.getElementsByTagName("position");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				Integer score = Integer.parseInt(eElement.getAttribute("score"));
				Integer type = Integer.parseInt(eElement.getAttribute("type"));
				Integer rank = Integer.parseInt(eElement.getTextContent());

				// System.out.println("type: " + type + " score: " + score + "
				// rank: " + rank);

				// 0 Total, 1 Economy, 2 Research, 3 Military, 4 Military Built,
				// 5 Military Destroyed, 6 Military Lost, 7 Honor
				switch (type) {
				case 0:
					s.setTotal(score);
					s.setTotalRank(rank);
					break;
				case 1:
					s.setEconomy(score);
					s.setEconomyRank(rank);
					break;
				case 2:
					s.setResearch(score);
					s.setResearchRank(rank);
					break;
				case 3:
					s.setMilitary(score);
					s.setMilitaryRank(rank);
					s.setShips((eElement.getAttribute("ships") == null) ? null : Integer.parseInt(eElement.getAttribute("ships")));
					/*
					 * Integer ships = (eElement.getAttribute("ships").length()
					 * == 0) ? null :
					 * Integer.parseInt(eElement.getAttribute("ships")); if
					 * (ships == null) { preparedStatement.setNull(6,
					 * Types.INTEGER); } else { s.setShips(ships); }
					 */
					break;
				case 4:
					s.setMilitaryBuilt(score);
					s.setMilitaryBuiltRank(rank);
					break;
				case 5:
					s.setMilitaryDestroyed(score);
					s.setMilitaryDestroyedRank(rank);
					break;
				case 6:
					s.setMilitaryLost(score);
					s.setMilitaryLostRank(rank);
					break;
				case 7:
					s.setHonor(score);
					s.setHonorRank(rank);
					break;
				}
			}
		}

		System.out.println(s);
		this.scores.add(s);

		// --------------------------------
		nList = document.getElementsByTagName("planet");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			// <planet id="33634942" name="Michigan" coords="3:18:12" />
			Planet p = new Planet();
			p.setPlayerId(this.playerId);
			p.setDayId(dayId);

			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				p.setPlanetId(Integer.parseInt(eElement.getAttribute("id")));
				p.setName(eElement.getAttribute("name"));
				p.setCoords(eElement.getAttribute("coords"));
			}

			System.out.println(p);
		}

	}
}
