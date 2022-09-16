package com.sous.health.pharmacie.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="date_commande")
	private LocalDateTime dateCommande = LocalDateTime.now();
	@Column(name="montant")
	private double montant;
	
	@OneToMany( targetEntity=Product.class, mappedBy="commande" )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<Product> products = new HashSet<>();
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(LocalDateTime dateCommande, double montant, Set<Product> products) {
		super();
		this.dateCommande = dateCommande;
		this.montant = montant;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCommande, id, montant, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(dateCommande, other.dateCommande) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant)
				&& Objects.equals(products, other.products);
	}

	

	
}
