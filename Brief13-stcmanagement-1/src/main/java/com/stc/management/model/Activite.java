package com.stc.management.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="activite")
public class Activite {
	@Id
	@Column(name="idActivite")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String titre;
	@Column
	private String description;
//	 @CreationTimestamp
//	    @Column(updatable = true)
//	    Timestamp dateDebut;
//	 @CreationTimestamp
//	    @Column(updatable = true)
//	    Timestamp dateFin;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column
	private boolean etat;
	
	@ManyToOne
    @JoinColumn(name = "idTypeActivite")
    private TypeActivite typeactivite;
	
	 @ManyToMany(mappedBy = "activites")
	    private Set<Participant> participants;	 
	 
	 @ManyToMany(mappedBy = "activites")
	    private Set<Exercice> exercices;
	 
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date date) {
		this.dateDebut = date;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date date) {
		this.dateFin = date;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public TypeActivite getTypeactivite() {
		return typeactivite;
	}

	public void setTypeactivite(TypeActivite typeactivite) {
		this.typeactivite = typeactivite;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Set<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<Exercice> exercices) {
		this.exercices = exercices;
	}
	

}
