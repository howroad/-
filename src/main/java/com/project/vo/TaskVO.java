package com.project.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.project.pojo.TCar;
import com.project.pojo.TMessage;
import com.project.pojo.TTask;
import com.project.pojo.TUser;

//USED
public class TaskVO {
	private String taskId;
	private String eventCode;
	private String taskName;
	private String taskAddress;
	private String taskOrgName;
	private String taskTime;
	private String taskTimeLength;
	private String taskLevelValue;
	private String taskType;
	private Integer taskPersonNum;
	private Integer taskCarNum;
	private String taskStartTime;
	private String goTime;
	private Integer realPersonNum;
	private Integer realCarNum;
	private String taskPerson;
	private String taskPersonTel;
	private Set<TMessage> messages = new HashSet<TMessage>(0);
	private List<TUser> users = new ArrayList<TUser>();
	private List<TCar> cars = new ArrayList<TCar>();
	
	
	public TaskVO(TTask task0,String goTime,TUser user,List<TUser> users,List<TCar> cars) {
		super();
		this.taskId = task0.getTaskId();
		this.eventCode = task0.getEventCode();
		this.taskName = task0.getTaskName();
		this.taskAddress = task0.getTaskAddress();
		this.taskOrgName = task0.getTOrganization().getOrgName();
		this.taskTime = task0.getTaskTime();
		this.taskTimeLength = "";
		this.taskLevelValue = task0.getTaskLevel();//TODO
		this.taskType = task0.getTaskType();
		this.taskPersonNum = task0.getTaskPersonNum();
		this.taskCarNum = task0.getTaskCarNum();
		this.taskStartTime = task0.getTaskTime();
		this.goTime = goTime;
		this.realPersonNum = task0.getTTaskUsers().size();
		this.realCarNum = task0.getTTaskCars().size();
		this.taskPerson = user==null?"无":user.getUserRname();
		this.taskPersonTel = user==null?"无":user.getUserTel();
		this.messages = task0.getTMessages();
		this.users = users;
		this.cars = cars;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getEventCode() {
		return eventCode;
	}


	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getTaskAddress() {
		return taskAddress;
	}


	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}


	public String getTaskOrgName() {
		return taskOrgName;
	}


	public void setTaskOrgName(String taskOrgName) {
		this.taskOrgName = taskOrgName;
	}


	public String getTaskTime() {
		return taskTime;
	}


	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}


	public String getTaskTimeLength() {
		return taskTimeLength;
	}


	public void setTaskTimeLength(String taskTimeLength) {
		this.taskTimeLength = taskTimeLength;
	}


	public String getTaskLevelValue() {
		return taskLevelValue;
	}


	public void setTaskLevelValue(String taskLevelValue) {
		this.taskLevelValue = taskLevelValue;
	}


	public String getTaskType() {
		return taskType;
	}


	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


	public Integer getTaskPersonNum() {
		return taskPersonNum;
	}


	public void setTaskPersonNum(Integer taskPersonNum) {
		this.taskPersonNum = taskPersonNum;
	}


	public Integer getTaskCarNum() {
		return taskCarNum;
	}


	public void setTaskCarNum(Integer taskCarNum) {
		this.taskCarNum = taskCarNum;
	}


	public String getTaskStartTime() {
		return taskStartTime;
	}


	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}


	public String getGoTime() {
		return goTime;
	}


	public void setGoTime(String goTime) {
		this.goTime = goTime;
	}


	public Integer getRealPersonNum() {
		return realPersonNum;
	}


	public void setRealPersonNum(Integer realPersonNum) {
		this.realPersonNum = realPersonNum;
	}


	public Integer getRealCarNum() {
		return realCarNum;
	}


	public void setRealCarNum(Integer realCarNum) {
		this.realCarNum = realCarNum;
	}


	public String getTaskPerson() {
		return taskPerson;
	}


	public void setTaskPerson(String taskPerson) {
		this.taskPerson = taskPerson;
	}


	public String getTaskPersonTel() {
		return taskPersonTel;
	}


	public void setTaskPersonTel(String taskPersonTel) {
		this.taskPersonTel = taskPersonTel;
	}


	public Set<TMessage> getMessages() {
		return messages;
	}


	public void setMessages(Set<TMessage> messages) {
		this.messages = messages;
	}


	public List<TUser> getUsers() {
		return users;
	}


	public void setUsers(List<TUser> users) {
		this.users = users;
	}


	public List<TCar> getCars() {
		return cars;
	}


	public void setCars(List<TCar> cars) {
		this.cars = cars;
	}


	
	
}
