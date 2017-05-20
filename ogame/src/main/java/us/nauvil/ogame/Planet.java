package us.nauvil.ogame;

public class Planet {

	// <planet id="33634942" name="Michigan" coords="3:18:12" />

	private Integer playerId;
	private Integer planetId;
	private Integer dayId;
	private String name;
	private String coords;
	private Integer galaxy;
	private Integer system;
	private Integer planet;

	@Override
	public String toString() {
		return "Planet [playerId=" + playerId + ", planetId=" + planetId + ", dayId=" + dayId + ", name=" + name + ", coords=" + coords + ", galaxy=" + galaxy + ", system=" + system + ", planet=" + planet + "]";
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

		if (coords != null) {
			String[] splits = coords.split(":");
			this.galaxy = Integer.parseInt(splits[0]);
			this.system = Integer.parseInt(splits[1]);
			this.planet = Integer.parseInt(splits[2]);
		}
	}

	public Integer getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Integer galaxy) {
		this.galaxy = galaxy;
	}

	public Integer getSystem() {
		return system;
	}

	public void setSystem(Integer system) {
		this.system = system;
	}

	public Integer getPlanet() {
		return planet;
	}

	public void setPlanet(Integer planet) {
		this.planet = planet;
	}

}
