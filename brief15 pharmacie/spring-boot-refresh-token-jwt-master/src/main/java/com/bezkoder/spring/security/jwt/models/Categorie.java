package com.bezkoder.spring.security.jwt.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")

public class Categorie{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="categorie_name")
	private String nameCat;
	
	@OneToMany
    @JoinColumn(name = "categorie_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Set<Product> products;
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
