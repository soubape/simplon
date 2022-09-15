package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Categorie")

public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="categorie_name")
	private String nameCat;
	
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "id")	
	private User user;


	public Categorie(String nameCat, User user) {
		super();
		this.nameCat = nameCat;
		this.user = user;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nameCat, user);
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
				&& Objects.equals(user, other.user);
	}
	
}
