package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product")

public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	  @JoinColumn(name = "categorie_id")
//	  @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Categorie categorie;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	  @JoinColumn(name = "user_id")
//	  @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	  @JoinColumn(name = "commande_id")
//	  @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Commande commande;
//	@ManyToMany(fetch = FetchType.EAGER,
//		      cascade = {
//		          CascadeType.PERSIST,
//		          CascadeType.MERGE
//		      },
//		      mappedBy = "products")
//		  @JsonIgnore
//		  private Set<Categorie> categories = new HashSet<>();
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Product(String title, String description, int quantity, Categorie categorie) {
	super();
	this.title = title;
	this.description = description;
	this.quantity = quantity;
	this.categorie = categorie;
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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, quantity, title);
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
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& quantity == other.quantity && Objects.equals(title, other.title);
	}


}
