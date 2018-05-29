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
 * TTaskCar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_task_car", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TTaskCar implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2692174015178677894L;
	private String taskCarId;
	private TTask TTask;
	private TCar TCar;

	// Constructors

	/** default constructor */
	public TTaskCar() {
	}

	/** full constructor */
	public TTaskCar(TTask TTask, TCar TCar) {
		this.TTask = TTask;
		this.TCar = TCar;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "task_car_id", unique = true, nullable = false, length = 32)

	public String getTaskCarId() {
		return this.taskCarId;
	}

	public void setTaskCarId(String taskCarId) {
		this.taskCarId = taskCarId;
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
	@JoinColumn(name = "car_id")

	public TCar getTCar() {
		return this.TCar;
	}

	public void setTCar(TCar TCar) {
		this.TCar = TCar;
	}

}