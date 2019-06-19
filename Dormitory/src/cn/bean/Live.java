package cn.bean;

import java.sql.Date;

public class Live {
	private String username;
	private String buildingId;
	private Date livetime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public Date getLivetime() {
		return livetime;
	}

	public void setLivetime(Date livetime) {
		this.livetime = livetime;
	}

}
