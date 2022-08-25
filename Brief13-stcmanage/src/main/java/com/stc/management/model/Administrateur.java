package com.stc.management.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="administrateur")
public class Administrateur{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAdministrateur")
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String telephone;
	
}
