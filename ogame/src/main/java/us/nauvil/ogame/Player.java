package us.nauvil.ogame;

public class Player {
	private Integer id;
	private String name;
	private String status;
	private Integer alliance;
	private Integer dayId;

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", status=" + status + ", alliance=" + alliance + ", dayId=" + dayId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAlliance() {
		return alliance;
	}

	public void setAlliance(Integer alliance) {
		this.alliance = alliance;
	}

	public Integer getDayId() {
		return dayId;
	}

	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

}
