package com.stc.management.model;

import javax.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)  
public class Users {
	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
    private String name;
	@Column
    private String username;
	@Column
    private String email;
	@Column
    private String password;
	@Column
    private String telephone;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	public Users(long id, String name, String username, String email, String password, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
    
	
	

}
