/**
 * 
 */
package com.project.vo;

/**
 * @author howroad
 * @Date 2018年5月18日
 * @version 1.0
 */
public class TaskTopicDto {
	private String orgCode;
	private String rCode;
	private String rPersonNum;
	private String rCarNum;
	private String rAddress;
	private String rType;
	private String rName;
	private String rLevel;
	public TaskTopicDto() {
		super();
	}
	public TaskTopicDto(String orgCode, String rCode, String rPersonNum, String rCarNum, String rAddress, String rType, String rName, String rLevel) {
		super();
		this.orgCode = orgCode;
		this.rCode = rCode;
		this.rPersonNum = rPersonNum;
		this.rCarNum = rCarNum;
		this.rAddress = rAddress;
		this.rType = rType;
		this.rName = rName;
		this.rLevel = rLevel;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getrCode() {
		return rCode;
	}
	public void setrCode(String rCode) {
		this.rCode = rCode;
	}
	public String getrPersonNum() {
		return rPersonNum;
	}
	public void setrPersonNum(String rPersonNum) {
		this.rPersonNum = rPersonNum;
	}
	public String getrCarNum() {
		return rCarNum;
	}
	public void setrCarNum(String rCarNum) {
		this.rCarNum = rCarNum;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrLevel() {
		return rLevel;
	}
	public void setrLevel(String rLevel) {
		this.rLevel = rLevel;
	}
	
}
