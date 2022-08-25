package com.stc.management.model;

import java.util.Objects;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="responsable")
@Embeddable
public class Responsable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String domaine;
	@Column
	private boolean etat;
	private TypeResponsable typeresponsable;
	
	
	public Responsable(String name, String telephone, String domaine, boolean etat, TypeResponsable typeresponsable) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.domaine = domaine;
		this.etat = etat;
		this.typeresponsable = typeresponsable;
	}


	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
