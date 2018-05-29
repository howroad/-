/**
 * 
 */
package com.project.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author howroad
 * @Date 2018年5月18日
 * @version 1.0
 */
public class OrgStateDto {
	private String orgCode;
	private String orgName;
	private String rCurrentPerson;
	private String rCurrentCar;
	private String rTotalCar;
	private String rTotalPerson;
	public OrgStateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrgStateDto(String orgCode, String rTotalPerson, String rCurrentPerson, String rTotalCar, String rCurrentCar,String orgName) {
		super();
		this.orgCode = orgCode;
		this.rTotalPerson = rTotalPerson;
		this.rCurrentPerson = rCurrentPerson;
		this.rTotalCar = rTotalCar;
		this.rCurrentCar = rCurrentCar;
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getrCurrentPerson() {
		return rCurrentPerson;
	}
	public void setrCurrentPerson(String rCurrentPerson) {
		this.rCurrentPerson = rCurrentPerson;
	}
	public String getrCurrentCar() {
		return rCurrentCar;
	}
	public void setrCurrentCar(String rCurrentCar) {
		this.rCurrentCar = rCurrentCar;
	}
	@JsonIgnore
	public String getrTotalCar() {
		return rTotalCar;
	}
	public void setrTotalCar(String rTotalCar) {
		this.rTotalCar = rTotalCar;
	}
	@JsonIgnore
	public String getrTotalPerson() {
		return rTotalPerson;
	}
	public void setrTotalPerson(String rTotalPerson) {
		this.rTotalPerson = rTotalPerson;
	}

	
}
