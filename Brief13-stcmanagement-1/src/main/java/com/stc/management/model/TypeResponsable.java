package com.stc.management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="typeresponsable")
public class TypeResponsable {
	@Id
	@Column(name="idTypeResponsable")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String type;
	
	@OneToMany(mappedBy = "typeresponsable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsable> responsables;

	
	public TypeResponsable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Responsable> getResponsables() {
		return responsables;
	}


	public void setResponsables(List<Responsable> responsables) {
		this.responsables = responsables;
	}


	
}
