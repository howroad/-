package com.project.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TOrganization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_organization", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TOrganization implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676693413582763630L;
	private String orgId;
	private String orgName;
	private String orgCode;
	private String orgPic;
	private String orgType;
	private String orgArea;
	private Set<TCar> TCars = new HashSet<TCar>(0);
	private Set<TUser> TUsers = new HashSet<TUser>(0);
	private Set<TTask> TTasks = new HashSet<TTask>(0);

	// Constructors

	/** default constructor */
	public TOrganization() {
	}

	/** full constructor */
	public TOrganization(String orgName, String orgCode, String orgPic, String orgType, String orgArea, Set<TCar> TCars,
			Set<TUser> TUsers, Set<TTask> TTasks) {
		this.orgName = orgName;
		this.orgCode = orgCode;
		this.orgPic = orgPic;
		this.orgType = orgType;
		this.orgArea = orgArea;
		this.TCars = TCars;
		this.TUsers = TUsers;
		this.TTasks = TTasks;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "org_id", unique = true, nullable = false, length = 32)

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "org_name", length = 32)

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "org_code", length = 32)

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "org_pic")

	public String getOrgPic() {
		return this.orgPic;
	}

	public void setOrgPic(String orgPic) {
		this.orgPic = orgPic;
	}

	@Column(name = "org_type", length = 24)

	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@Column(name = "org_area", length = 24)

	public String getOrgArea() {
		return this.orgArea;
	}

	public void setOrgArea(String orgArea) {
		this.orgArea = orgArea;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganization")
	@JsonIgnore
	public Set<TCar> getTCars() {
		return this.TCars;
	}

	public void setTCars(Set<TCar> TCars) {
		this.TCars = TCars;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganization")
	@JsonIgnore
	public Set<TUser> getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set<TUser> TUsers) {
		this.TUsers = TUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganization")
	@JsonIgnore
	public Set<TTask> getTTasks() {
		return this.TTasks;
	}

	public void setTTasks(Set<TTask> TTasks) {
		this.TTasks = TTasks;
	}

}