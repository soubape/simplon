package com.stc.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="participant")
public class Participant{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String fullname;
	@Column
	private String structure;
	
	@ManyToOne
    @JoinColumn(name = "idResponsable")
    private Responsable responsable;
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "participant")
//	private List<Activite> activite = new ArrayList<Activite>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "participants")
	private List<Activite> activites = new ArrayList<Activite>();
	
	
	public Participant(String name, String telephone, String fullname, String structure, Responsable responsable,
			List<Activite> activites) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.fullname = fullname;
		this.structure = structure;
		this.responsable = responsable;
		this.activites = activites;
	}


	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
