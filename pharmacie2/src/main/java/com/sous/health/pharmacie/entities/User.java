package com.sous.health.pharmacie.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "fullname"),
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "password")
    })

public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotBlank
	@Column(name="fullname")
	private String fullname;
	@NotBlank
	@Column(name="username")
	private String username;
	@NotBlank
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	  @JoinTable(name = "user_roles", 
	             joinColumns = @JoinColumn(name = "user_id"),
	             inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
	
	@OneToMany( targetEntity=Product.class, mappedBy="user" )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<Product> products = new HashSet<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotBlank String username, @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String fullname, @NotBlank String username, @NotBlank String password, Set<Role> roles,
			Set<Product> products) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.products = products;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullname, id, password, products, roles, username);
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
		return Objects.equals(fullname, other.fullname) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(products, other.products)
				&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
	}

	
}
