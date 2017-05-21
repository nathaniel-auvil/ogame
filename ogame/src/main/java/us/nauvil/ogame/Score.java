package us.nauvil.ogame;

public class Score {

	// 0 Total, 1 Economy, 2 Research, 3 Military, 5 Military Built, 6 Military
	// Destroyed, 4 Military Lost, 7 Honor
	private Integer playerId;
	private Integer dayId;

	private Integer total;
	private Integer totalRank;
	private Integer economy;
	private Integer economyRank;
	private Integer research;
	private Integer researchRank;
	private Integer military;
	private Integer militaryRank;
	private Integer ships;
	private Integer militaryBuilt;
	private Integer militaryBuiltRank;
	private Integer militaryDestroyed;
	private Integer militaryDestroyedRank;
	private Integer militaryLost;
	private Integer militaryLostRank;
	private Integer honor;
	private Integer honorRank;

	@Override
	public String toString() {
		return "Score [playerId=" + playerId + ", dayId=" + dayId + ", total=" + total + ", totalRank=" + totalRank + ", economy=" + economy + ", economyRank=" + economyRank + ", research=" + research + ", researchRank=" + researchRank + ", military=" + military + ", militaryRank=" + militaryRank + ", ships=" + ships + ", militaryBuilt=" + militaryBuilt + ", militaryBuiltRank=" + militaryBuiltRank + ", militaryDestroyed=" + militaryDestroyed + ", militaryDestroyedRank=" + militaryDestroyedRank
				+ ", militaryLost=" + militaryLost + ", militaryLostRank=" + militaryLostRank + ", honor=" + honor + ", honorRank=" + honorRank + "]";
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getDayId() {
		return dayId;
	}

	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalRank() {
		return totalRank;
	}

	public void setTotalRank(Integer totalRank) {
		this.totalRank = totalRank;
	}

	public Integer getEconomy() {
		return economy;
	}

	public void setEconomy(Integer economy) {
		this.economy = economy;
	}

	public Integer getEconomyRank() {
		return economyRank;
	}

	public void setEconomyRank(Integer economyRank) {
		this.economyRank = economyRank;
	}

	public Integer getResearch() {
		return research;
	}

	public void setResearch(Integer research) {
		this.research = research;
	}

	public Integer getResearchRank() {
		return researchRank;
	}

	public void setResearchRank(Integer researchRank) {
		this.researchRank = researchRank;
	}

	public Integer getMilitary() {
		return military;
	}

	public void setMilitary(Integer military) {
		this.military = military;
	}

	public Integer getMilitaryRank() {
		return militaryRank;
	}

	public void setMilitaryRank(Integer militaryRank) {
		this.militaryRank = militaryRank;
	}

	public Integer getShips() {
		return ships;
	}

	public void setShips(Integer ships) {
		this.ships = ships;
	}

	public Integer getMilitaryBuilt() {
		return militaryBuilt;
	}

	public void setMilitaryBuilt(Integer militaryBuilt) {
		this.militaryBuilt = militaryBuilt;
	}

	public Integer getMilitaryBuiltRank() {
		return militaryBuiltRank;
	}

	public void setMilitaryBuiltRank(Integer militaryBuiltRank) {
		this.militaryBuiltRank = militaryBuiltRank;
	}

	public Integer getMilitaryDestroyed() {
		return militaryDestroyed;
	}

	public void setMilitaryDestroyed(Integer militaryDestroyed) {
		this.militaryDestroyed = militaryDestroyed;
	}

	public Integer getMilitaryDestroyedRank() {
		return militaryDestroyedRank;
	}

	public void setMilitaryDestroyedRank(Integer militaryDestroyedRank) {
		this.militaryDestroyedRank = militaryDestroyedRank;
	}

	public Integer getMilitaryLost() {
		return militaryLost;
	}

	public void setMilitaryLost(Integer militaryLost) {
		this.militaryLost = militaryLost;
	}

	public Integer getMilitaryLostRank() {
		return militaryLostRank;
	}

	public void setMilitaryLostRank(Integer militaryLostRank) {
		this.militaryLostRank = militaryLostRank;
	}

	public Integer getHonor() {
		return honor;
	}

	public void setHonor(Integer honor) {
		this.honor = honor;
	}

	public Integer getHonorRank() {
		return honorRank;
	}

	public void setHonorRank(Integer honorRank) {
		this.honorRank = honorRank;
	}

}
