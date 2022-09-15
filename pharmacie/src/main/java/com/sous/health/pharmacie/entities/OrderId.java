package com.sous.health.pharmacie.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559454307951175669L;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Product product;
	@ManyToOne
	private User user;
	
	
	private LocalDateTime creationDateTime;
	
	public OrderId() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public OrderId(Categorie categorie, Product product, User user, LocalDateTime creationDateTime) {
		super();
		this.categorie = categorie;
		this.product = product;
		this.user = user;
		this.creationDateTime = creationDateTime;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CREATION_DATE_TIME")
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDateTime, product, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderId other = (OrderId) obj;
		return Objects.equals(creationDateTime, other.creationDateTime) && Objects.equals(product, other.product)
				&& Objects.equals(user, other.user);
	}

	
	
	
	
	

}
