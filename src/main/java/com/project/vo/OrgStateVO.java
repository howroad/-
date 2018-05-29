package com.project.vo;

public class OrgStateVO {

	private String orgId;
	private Integer currentPersonNum;
	private Integer currentCarNum;
	private Integer personNum;
	private Integer carNum;
	
	public OrgStateVO() {
		super();
	}
	
	
	public OrgStateVO(String orgId, Integer currentPersonNum, Integer currentCarNum, Integer personNum,
			Integer carNum) {
		super();
		this.orgId = orgId;
		this.currentPersonNum = currentPersonNum;
		this.currentCarNum = currentCarNum;
		this.personNum = personNum;
		this.carNum = carNum;
	}


	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public Integer getCurrentPersonNum() {
		return currentPersonNum;
	}
	public void setCurrentPersonNum(Integer currentPersonNum) {
		this.currentPersonNum = currentPersonNum;
	}
	public Integer getCurrentCarNum() {
		return currentCarNum;
	}
	public void setCurrentCarNum(Integer currentCarNum) {
		this.currentCarNum = currentCarNum;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	public Integer getCarNum() {
		return carNum;
	}
	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}


	@Override
	public String toString() {
		return "OrgStateVO [orgId=" + orgId + ", currentPersonNum=" + currentPersonNum + ", currentCarNum="
				+ currentCarNum + ", personNum=" + personNum + ", carNum=" + carNum + "]";
	}
	
}
