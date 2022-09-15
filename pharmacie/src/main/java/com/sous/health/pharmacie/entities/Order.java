package com.sous.health.pharmacie.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.*;


@Entity
@Table(name = "Order")
@AssociationOverrides({
@AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "PORDUCT_ID")),
@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "USER_ID")),
//@AssociationOverride(name = "pk.categorie", joinColumns = @JoinColumn(name = "CATEGORIE_ID"))
})
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6121508225702227179L;
	@Column(name="order_id")
	private OrderId pk = new OrderId();
	@Column(name="begin_date")
	private LocalDate beginDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Column(name="status")
	private OrderStatus status;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(OrderId pk, LocalDate beginDate, LocalDate endDate, OrderStatus status) {
		super();
		this.pk = pk;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.status = status;
	}

	@EmbeddedId
	public OrderId getPk() {
		return pk;
	}

	public void setPk(OrderId pk) {
		this.pk = pk;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	 @Enumerated(EnumType.STRING)
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beginDate, endDate, pk, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(beginDate, other.beginDate) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(pk, other.pk) && status == other.status;
	}
	
	
	
	
	
}
