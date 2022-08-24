package com.stc.management.model;

import javax.persistence.*;

@Entity
@Table(name="administrateur")
@PrimaryKeyJoinColumn( name = "idAdmin" )
public class Administrateur extends Users{
	
	
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(Long id,String name, String username, String email, String password, String telephone) {
		super(id,name, username, email, password, telephone);
		// TODO Auto-generated constructor stub
	}

	
}
