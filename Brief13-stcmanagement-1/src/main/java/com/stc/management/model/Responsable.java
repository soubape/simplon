package com.stc.management.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="responsable")
@PrimaryKeyJoinColumn( name = "idResponsable" )
public class Responsable extends Users{
	@Column
	private String domaine;
	@Column
	private boolean etat;
	
	@OneToMany(mappedBy = "responsable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participants;
	
	@ManyToOne
    @JoinColumn(name = "idTypeResponsable")
    private TypeResponsable typeresponsable;

	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Responsable(long id, String name, String username, String email, String password, String telephone) {
		super(id, name, username, email, password, telephone);
		// TODO Auto-generated constructor stub
	}
	
	public Responsable(String domaine, boolean etat, List<Participant> participants, TypeResponsable typeresponsable) {
		super();
		this.domaine = domaine;
		this.etat = etat;
		this.participants = participants;
		this.typeresponsable = typeresponsable;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public TypeResponsable getTyperesponsable() {
		return typeresponsable;
	}

	public void setTyperesponsable(TypeResponsable typeresponsable) {
		this.typeresponsable = typeresponsable;
	}
	
}
