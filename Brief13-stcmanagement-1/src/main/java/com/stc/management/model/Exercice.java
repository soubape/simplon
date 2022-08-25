package com.stc.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
@Table(name="exercice")
public class Exercice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private int annee;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column
	private boolean statut;
	
	@OneToMany
	List<Activite> activites = new ArrayList<>();
	
	
}
