package com.stc.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
@Table(name="activite")
public class Activite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String titre;
	@Column
	private String description;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column
	private boolean etat;
	private TypeActivite typeactivite;
	
	 @ManyToOne
	    private Exercice exercice;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "activite_participant",
		joinColumns = { @JoinColumn(name = "id_activite")},
		inverseJoinColumns = { @JoinColumn (name = "id_participant")})	
	private List<Participant> participants = new ArrayList<>();
	
	
}
