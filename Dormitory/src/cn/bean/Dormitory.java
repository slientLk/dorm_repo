package cn.bean;

public class Dormitory {
	private String buildingId;
	private String buildingName;
	private String buildingFloor;
	private int max_num;
	private int lived_num;

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingFloor() {
		return buildingFloor;
	}

	public void setBuildingFloor(String buildingFloor) {
		this.buildingFloor = buildingFloor;
	}

	public int getMax_num() {
		return max_num;
	}

	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}

	public int getLived_num() {
		return lived_num;
	}

	public void setLived_num(int lived_num) {
		this.lived_num = lived_num;
	}

}
