package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="product_title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="product_quantity")
	private int quantity;
	
	@ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")	
	private Categorie categorie;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk_product", cascade = CascadeType.ALL)
	Set<Order> orders = new HashSet<Order>();


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String title, String description, int quantity,Categorie categorie, Set<Order> orders) {
		super();
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.categorie = categorie;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	public Set<Order> getOrders() {
		return orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categorie, description, id, orders, quantity, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(categorie, other.categorie) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(orders, other.orders) && quantity == other.quantity
				&& Objects.equals(title, other.title);
	}
    
    

}
