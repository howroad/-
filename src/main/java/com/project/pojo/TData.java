package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_data", catalog = "db_yjbzxt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2796122163985831422L;
	private Integer dataId;
	private String dataType;
	private String dataKey;
	private String dataValue;
	private String dataDesc;

	// Constructors

	/** default constructor */
	public TData() {
	}

	/** full constructor */
	public TData(String dataType, String dataKey, String dataValue, String dataDesc) {
		this.dataType = dataType;
		this.dataKey = dataKey;
		this.dataValue = dataValue;
		this.dataDesc = dataDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "data_id", unique = true, nullable = false)

	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	@Column(name = "data_type", length = 24)

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_key", length = 24)

	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	@Column(name = "data_value", length = 24)

	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	@Column(name = "data_desc", length = 100)

	public String getDataDesc() {
		return this.dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

	@Override
	public String toString() {
		return "TData [dataId=" + dataId + ", dataType=" + dataType + ", dataKey=" + dataKey + ", dataValue="
				+ dataValue + ", dataDesc=" + dataDesc + "]";
	}

}