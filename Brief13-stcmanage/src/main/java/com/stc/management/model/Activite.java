package com.stc.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import lombok.Data;
@Data
@Entity
@Table(name="activite")
public class Activite {

	@Id
	@Column(name="id_activite")
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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "activite_participant",
		joinColumns = { @JoinColumn(name = "id_activite")},
		inverseJoinColumns = { @JoinColumn (name = "id_participant")})
	private List<Participant> participants =new ArrayList<Participant>();
	
	 @ManyToOne( cascade = CascadeType.PERSIST )
	    @JoinColumn( name = "id_responsable", nullable = true )
	    private Responsable responsable;

	 
	 
	public Activite(String titre, String description, Date dateDebut, Date dateFin, boolean etat,
			TypeActivite typeactivite, List<Participant> participants, Responsable responsable) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
		this.typeactivite = typeactivite;
		this.participants = participants;
		this.responsable = responsable;
	}



	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
