package us.nauvil.ogame;

public class Planet {

	// <planet id="33634942" name="Michigan" coords="3:18:12" />

	private Integer playerId;
	private Integer planetId;
	private Integer dayId;
	private String name;
	private String coords;

	@Override
	public String toString() {
		return "Planet [playerId=" + playerId + ", planetId=" + planetId + ", dayId=" + dayId + ", name=" + name + ", coords=" + coords + "]";
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getPlanetId() {
		return planetId;
	}

	public void setPlanetId(Integer planetId) {
		this.planetId = planetId;
	}

	public Integer getDayId() {
		return dayId;
	}

	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoords() {
		return coords;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

}
