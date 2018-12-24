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
@Table(name = "tbl_inventory")
public class Inventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8334908157407338425L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id")
	@JsonProperty("product_id")
	private Long productId;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "quantity")
	@JsonProperty("quantity")
	private Integer quantity;

	@Column(name = "active_flag")
	@JsonProperty("active_flag")
	private Integer activeFlag;

	@Column(name = "createdon")
	@JsonProperty("createdon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;

	@Column(name = "updatedon")
	@JsonProperty("updatedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
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
		return "Inventory [productId=" + productId + ", name=" + name + ", quantity="
				+ quantity + ", activeFlag=" + activeFlag + ", createdon=" + createdon + ", updatedOn=" + updatedOn
				+ "]";
	}

}
