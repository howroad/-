package com.project.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.project.pojo.TOrganization;
import com.project.pojo.TUser;

public class OrganizationVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4777543420079411110L;
	private String orgId;
	private String orgName;
	private String areaKey;
	private String orgTypeKey;
	private String orgUserName;
	private String orgUserTel;
	private Integer personCurrentNum;
	private Integer carCurrentNum;
	private Integer personNum;
	private Integer carNum;
	private String userName;
	private String userPwd;
	private String orgPic;
	private String orgCode;

	public OrganizationVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationVO(TOrganization org0) {
		this.orgId = org0.getOrgId();
		this.orgName = org0.getOrgName();
		this.areaKey = org0.getOrgArea();
		this.orgTypeKey = org0.getOrgType();
		this.orgUserName = "";
		this.orgUserTel = "";
		this.personCurrentNum = 0;
		this.carCurrentNum = 0;
		this.personNum = org0.getTUsers().size();
		this.carNum = org0.getTCars().size();
		this.userName = "";
		this.userPwd = "";
		this.orgPic = org0.getOrgPic();
		this.orgCode = org0.getOrgCode();
	}

	public OrganizationVO(String orgId, String orgName, String areaKey, String orgTypeKey, String orgUserName, String orgUserTel,
			Integer personCurrentNum, Integer carCurrentNum, Integer personNum, Integer carNum, String userName, String userPwd, String orgPic,
			String orgCode) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.areaKey = areaKey;
		this.orgTypeKey = orgTypeKey;
		this.orgUserName = orgUserName;
		this.orgUserTel = orgUserTel;
		this.personCurrentNum = personCurrentNum;
		this.carCurrentNum = carCurrentNum;
		this.personNum = personNum;
		this.carNum = carNum;
		this.userName = userName;
		this.userPwd = userPwd;
		this.orgPic = orgPic;
		this.orgCode = orgCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAreaKey() {
		return areaKey;
	}

	public void setAreaKey(String areaKey) {
		this.areaKey = areaKey;
	}

	public String getOrgTypeKey() {
		return orgTypeKey;
	}

	public void setOrgTypeKey(String orgTypeKey) {
		this.orgTypeKey = orgTypeKey;
	}

	public String getOrgUserName() {
		return orgUserName;
	}

	public void setOrgUserName(String orgUserName) {
		this.orgUserName = orgUserName;
	}

	public String getOrgUserTel() {
		return orgUserTel;
	}

	public void setOrgUserTel(String orgUserTel) {
		this.orgUserTel = orgUserTel;
	}

	public Integer getPersonCurrentNum() {
		return personCurrentNum;
	}

	public void setPersonCurrentNum(Integer personCurrentNum) {
		this.personCurrentNum = personCurrentNum;
	}

	public Integer getCarCurrentNum() {
		return carCurrentNum;
	}

	public void setCarCurrentNum(Integer carCurrentNum) {
		this.carCurrentNum = carCurrentNum;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getOrgPic() {
		return orgPic;
	}

	public void setOrgPic(String orgPic) {
		this.orgPic = orgPic;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public TOrganization getOrganization() {
		return new TOrganization(orgName, orgCode, orgPic, orgTypeKey, areaKey, null, null, null);
	}

	public TUser getUser() {
		return new TUser(getOrganization(), orgUserName, userPwd, userName, orgPic, "男", "2000-1-1", orgUserTel, orgName, "",
				LocalDateTime.now().toString(), 0, 0, 1, 0, null, null);
	}

	@Override
	public String toString() {
		return "OrganizationVO [orgId=" + orgId + ", orgName=" + orgName + ", areaKey=" + areaKey + ", orgTypeKey=" + orgTypeKey + ", orgUserName="
				+ orgUserName + ", orgUserTel=" + orgUserTel + ", personCurrentNum=" + personCurrentNum + ", carCurrentNum=" + carCurrentNum
				+ ", personNum=" + personNum + ", carNum=" + carNum + ", userName=" + userName + ", userPwd=" + userPwd + ", orgPic=" + orgPic
				+ ", orgCode=" + orgCode + "]";
	}

}
