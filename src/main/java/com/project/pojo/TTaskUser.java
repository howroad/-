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
 * TTaskUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_task_user", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TTaskUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133072204042258628L;
	// Fields

	private String taskUserId;
	private TTask TTask;
	private TUser TUser;

	// Constructors

	/** default constructor */
	public TTaskUser() {
	}

	/** full constructor */
	public TTaskUser(TTask TTask, TUser TUser) {
		this.TTask = TTask;
		this.TUser = TUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "task_user_id", unique = true, nullable = false, length = 32)

	public String getTaskUserId() {
		return this.taskUserId;
	}

	public void setTaskUserId(String taskUserId) {
		this.taskUserId = taskUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id")

	public TTask getTTask() {
		return this.TTask;
	}

	public void setTTask(TTask TTask) {
		this.TTask = TTask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

}