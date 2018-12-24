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
@Table(name = "tbl_order")
public class Order implements Serializable {

	private static final long serialVersionUID = -3526988103756419388L;

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("order_id")
	private Long orderId;

	@Column(name = "userid")
	@JsonProperty("userid")
	private Long userId;

	@Column(name = "product_id")
	@JsonProperty("product_id")
	private Long productId;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("order_date")
	private Date orderDate;

	@Column(name = "active_flag")
	@JsonProperty("active_flag")
	private Integer activeFlag;

	@Column(name = "updatedon")
	@JsonProperty("updatedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUserid() {
		return userId;
	}

	public void setUserid(Long userid) {
		this.userId = userid;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedOn=new Date();
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", orderDate=" + orderDate  + ", activeFlag=" + activeFlag + ", updatedOn=" + updatedOn + "]";
	}

}
