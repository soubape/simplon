package com.stc.management.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="participant")
@PrimaryKeyJoinColumn( name = "idParticipant" )
public class Participant extends Users{
	
	@Column
	private String fullname;
	@Column
	private String structure;
	
	@ManyToOne
    @JoinColumn(name = "idResponsable")
    private Responsable responsable;

	@Column
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    })
	    @JoinTable(
	            name = "participant_activite",
	            joinColumns = {@JoinColumn(name = "idUser")},
	            inverseJoinColumns = {@JoinColumn(name = "idActivite")}
	    )
	    private Set<Activite> activites;
	 
	
	 
	public Participant() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

	public Participant(Long id,String name, String username, String email, String password, String telephone) {
		super(id, name, username, email, password, telephone);
		// TODO Auto-generated constructor stub
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getStructure() {
		return structure;
	}


	public void setStructure(String structure) {
		this.structure = structure;
	}


	public Responsable getResponsable() {
		return responsable;
	}


	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}


	public Set<Activite> getActivites() {
		return activites;
	}


	public void setActivites(Set<Activite> activites) {
		this.activites = activites;
	}

}
