package com.task.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_account")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 288628866133415361L;

	@Id
	@Column(name = "userid")
	@JsonProperty("userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userid;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "mobile")
	@JsonProperty("mobile")
	private Integer mobile;

	@Column(name = "address")
	@JsonProperty("address")
	private String address;

	@Column(name = "active_flag")
	@JsonProperty("active_flag")
	private Long activeFlag;

	@Column(name = "createdon")
	@JsonProperty("createdon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;

	@JsonProperty("updatedon")
	@Column(name = "updatedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedOn=new Date();
	}
	
	@Override
	public String toString() {
		return "Account [userid=" + userid + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", activeFlag=" + activeFlag + ", createdon=" + createdon + ", updatedOn=" + updatedOn + "]";
	}

}
