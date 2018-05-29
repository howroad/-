package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TTaskHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_task_history", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TTaskHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7941552834338061832L;
	private String taskId;
	private String taskName;
	private String taskAddress;
	private String eventCode;
	private String startTime;
	private String endTime;
	private Integer personNum;
	private Integer carNum;
	private String leaderName;
	private String leaderTel;
	private String orgName;
	private String taskLevel;
	private String taskType;
	private String taskArea;

	// Constructors

	/** default constructor */
	public TTaskHistory() {
	}

	/** full constructor */
	public TTaskHistory(String taskName, String taskAddress, String eventCode, String startTime, String endTime,
			Integer personNum, Integer carNum, String leaderName, String leaderTel, String orgName, String taskLevel,
			String taskType, String taskArea) {
		super();
		this.taskName = taskName;
		this.taskAddress = taskAddress;
		this.eventCode = eventCode;
		this.startTime = startTime;
		this.endTime = endTime;
		this.personNum = personNum;
		this.carNum = carNum;
		this.leaderName = leaderName;
		this.leaderTel = leaderTel;
		this.orgName = orgName;
		this.taskLevel = taskLevel;
		this.taskType = taskType;
		this.taskArea = taskArea;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "task_id", unique = true, nullable = false, length = 32)

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "task_name", length = 32)

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "task_address", length = 50)

	public String getTaskAddress() {
		return this.taskAddress;
	}

	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}

	@Column(name = "event_code", length = 32)

	public String getEventCode() {
		return this.eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	@Column(columnDefinition="DATETIME",name = "start_time")

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(columnDefinition="DATETIME",name = "end_time")

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "person_num")

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	@Column(name = "car_num")

	public Integer getCarNum() {
		return this.carNum;
	}

	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}

	@Column(name = "leader_name", length = 32)

	public String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	@Column(name = "leader_tel", length = 15)

	public String getLeaderTel() {
		return this.leaderTel;
	}

	public void setLeaderTel(String leaderTel) {
		this.leaderTel = leaderTel;
	}

	@Column(name = "org_name", length = 32)

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "task_level", length = 32)

	public String getTaskLevel() {
		return this.taskLevel;
	}

	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}

	@Column(name = "task_type", length = 32)

	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "task_area", length = 24)
	
	public String getTaskArea() {
		return taskArea;
	}

	public void setTaskArea(String taskArea) {
		this.taskArea = taskArea;
	}

}