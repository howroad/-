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
 * TCar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_car", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TCar implements java.io.Serializable {
	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8557872351860581955L;
	private String carId;
	private TOrganization TOrganization;
	private String carLicense;
	private Integer carLoadNum;
	private String carDesc;
	private Integer carOutState;
	private Integer carBreakState;
	private Integer carDeleteState;
	private String carType;
	private Set<TTaskCar> TTaskCars = new HashSet<TTaskCar>(0);

	// Constructors

	/** default constructor */
	public TCar() {
	}

	public TCar(String carId) {
		super();
		this.carId = carId;
	}

	/** full constructor */
	public TCar(com.project.pojo.TOrganization tOrganization, String carLicense, Integer carLoadNum, String carDesc,
			Integer carOutState, Integer carBreakState, Integer carDeleteState, String carType,
			Set<TTaskCar> tTaskCars) {
		super();
		TOrganization = tOrganization;
		this.carLicense = carLicense;
		this.carLoadNum = carLoadNum;
		this.carDesc = carDesc;
		this.carOutState = carOutState;
		this.carBreakState = carBreakState;
		this.carDeleteState = carDeleteState;
		this.carType = carType;
		TTaskCars = tTaskCars;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "car_id", unique = true, nullable = false, length = 32)

	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")

	public TOrganization getTOrganization() {
		return this.TOrganization;
	}

	public void setTOrganization(TOrganization TOrganization) {
		this.TOrganization = TOrganization;
	}

	@Column(name = "car_license", length = 20)

	public String getCarLicense() {
		return this.carLicense;
	}

	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	@Column(name = "car_load_num")

	public Integer getCarLoadNum() {
		return this.carLoadNum;
	}

	public void setCarLoadNum(Integer carLoadNum) {
		this.carLoadNum = carLoadNum;
	}

	@Column(name = "car_desc", length = 50)

	public String getCarDesc() {
		return this.carDesc;
	}

	public void setCarDesc(String carDesc) {
		this.carDesc = carDesc;
	}

	@Column(name = "car_out_state")

	public Integer getCarOutState() {
		return this.carOutState;
	}

	public void setCarOutState(Integer carOutState) {
		this.carOutState = carOutState;
	}

	@Column(name = "car_break_state")

	public Integer getCarBreakState() {
		return this.carBreakState;
	}

	public void setCarBreakState(Integer carBreakState) {
		this.carBreakState = carBreakState;
	}
	
	@Column(name = "car_delete_state")
	
	public Integer getCarDeleteState() {
		return carDeleteState;
	}

	public void setCarDeleteState(Integer carDeleteState) {
		this.carDeleteState = carDeleteState;
	}

	@Column(name = "car_type", length = 24)

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCar")
	@JsonIgnore
	public Set<TTaskCar> getTTaskCars() {
		return this.TTaskCars;
	}

	public void setTTaskCars(Set<TTaskCar> TTaskCars) {
		this.TTaskCars = TTaskCars;
	}

}