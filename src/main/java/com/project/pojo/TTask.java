package com.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_task", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TTask implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7491919663310298272L;
	private String taskId;
	private TOrganization TOrganization;
	private String taskName;
	private String taskAddress;
	private String eventCode;
	private String taskTime;
	private Integer taskPersonNum;
	private Integer taskCarNum;
	private Integer taskState;
	private String taskType;
	private String taskLevel;
	private String userId;
	private Set<TMessage> TMessages = new HashSet<TMessage>(0);
	private Set<TTaskUser> TTaskUsers = new HashSet<TTaskUser>(0);
	private Set<TTaskCar> TTaskCars = new HashSet<TTaskCar>(0);

	// Constructors

	/** default constructor */
	public TTask() {
	}
	
	public TTask(String taskId) {
		super();
		this.taskId = taskId;
	}

	/** full constructor */
	public TTask(TOrganization TOrganization, String taskName, String taskAddress, String eventCode, String taskTime,
			Integer taskPersonNum, Integer taskCarNum, Integer taskState, String taskType, String taskLevel,
			String userId, Set<TMessage> TMessages, Set<TTaskUser> TTaskUsers, Set<TTaskCar> TTaskCars) {
		this.TOrganization = TOrganization;
		this.taskName = taskName;
		this.taskAddress = taskAddress;
		this.eventCode = eventCode;
		this.taskTime = taskTime;
		this.taskPersonNum = taskPersonNum;
		this.taskCarNum = taskCarNum;
		this.taskState = taskState;
		this.taskType = taskType;
		this.taskLevel = taskLevel;
		this.userId = userId;
		this.TMessages = TMessages;
		this.TTaskUsers = TTaskUsers;
		this.TTaskCars = TTaskCars;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")

	public TOrganization getTOrganization() {
		return this.TOrganization;
	}

	public void setTOrganization(TOrganization TOrganization) {
		this.TOrganization = TOrganization;
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

	@Column(columnDefinition="DATETIME",name = "task_time")

	public String getTaskTime() {
		return this.taskTime;
	}

	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}

	@Column(name = "task_person_num")

	public Integer getTaskPersonNum() {
		return this.taskPersonNum;
	}

	public void setTaskPersonNum(Integer taskPersonNum) {
		this.taskPersonNum = taskPersonNum;
	}

	@Column(name = "task_car_num")

	public Integer getTaskCarNum() {
		return this.taskCarNum;
	}

	public void setTaskCarNum(Integer taskCarNum) {
		this.taskCarNum = taskCarNum;
	}

	@Column(name = "task_state")

	public Integer getTaskState() {
		return this.taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	@Column(name = "task_type", length = 24)

	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "task_level", length = 24)

	public String getTaskLevel() {
		return this.taskLevel;
	}

	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}

	@Column(name = "user_id", length = 32)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTask")
	@JsonIgnore
	public Set<TMessage> getTMessages() {
		return this.TMessages;
	}

	public void setTMessages(Set<TMessage> TMessages) {
		this.TMessages = TMessages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTask")
	@JsonIgnore
	public Set<TTaskUser> getTTaskUsers() {
		return this.TTaskUsers;
	}

	public void setTTaskUsers(Set<TTaskUser> TTaskUsers) {
		this.TTaskUsers = TTaskUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTask")
	@JsonIgnore
	public Set<TTaskCar> getTTaskCars() {
		return this.TTaskCars;
	}

	public void setTTaskCars(Set<TTaskCar> TTaskCars) {
		this.TTaskCars = TTaskCars;
	}

}