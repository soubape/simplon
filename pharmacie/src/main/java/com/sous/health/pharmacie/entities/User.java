package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="User")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="fullname")
	private String fullname;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@OneToOne  @JoinColumn( name="id" )
	private Categorie categorie;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	Set<Order> orders = new HashSet<Order>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String fullname, String username, String password, Set<Order> orders) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categorie, fullname, orders, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(categorie, other.categorie) && Objects.equals(fullname, other.fullname)
				&& Objects.equals(orders, other.orders) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	
	
	
}
