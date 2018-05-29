package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_message", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2860549695376691941L;
	private String msgId;
	private TTask TTask;
	private String msgTime;
	private String msgContent;
	private String msgType;

	// Constructors

	/** default constructor */
	public TMessage() {
	}

	/** full constructor */
	public TMessage(TTask TTask, String msgTime, String msgContent, String msgType) {
		this.TTask = TTask;
		this.msgTime = msgTime;
		this.msgContent = msgContent;
		this.msgType = msgType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "msg_id", unique = true, nullable = false, length = 32)

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id")

	public TTask getTTask() {
		return this.TTask;
	}

	public void setTTask(TTask TTask) {
		this.TTask = TTask;
	}

	@Column(columnDefinition="DATETIME",name = "msg_time")

	public String getMsgTime() {
		return this.msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	@Column(name = "msg_content")

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Column(name = "msg_type", length = 24)

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}