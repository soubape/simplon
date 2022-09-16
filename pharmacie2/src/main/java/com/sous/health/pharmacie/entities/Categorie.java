package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Categorie")

public class Categorie{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="categorie_name")
	private String nameCat;
	
//	 @ManyToMany(fetch = FetchType.EAGER,
//		      cascade = {
//		          CascadeType.PERSIST,
//		          CascadeType.MERGE
//		      })
//		  @JoinTable(name = "Categorie_Product",
//		        joinColumns = { @JoinColumn(name = "id_categorie") },
//		        inverseJoinColumns = { @JoinColumn(name = "id_product") })
//	private Set<Product> products = new HashSet<>();


	@OneToMany( targetEntity=Product.class, mappedBy="categorie" )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<Product> products = new HashSet<>();

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nameCat, Set<Product> products) {
		super();
		this.nameCat = nameCat;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameCat, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameCat, other.nameCat)
				&& Objects.equals(products, other.products);
	}
	 
	
	
	

	
}
