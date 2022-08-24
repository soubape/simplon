package com.stc.management.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="exercice")
public class Exercice {
	@Id
	@Column(name="idExercice")
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
	
	/*@JoinColumn(name = "idAdmin")
    @OneToOne(fetch = FetchType.LAZY)
    private Administrateur administrateur;
	*/
	@Column
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    })
	    @JoinTable(
	            name = "exercice_activite",
	            joinColumns = {@JoinColumn(name = "idExercice")},
	            inverseJoinColumns = {@JoinColumn(name = "idActivite")}
	    )
	    private Set<Activite> activites;
	
	
	public Exercice() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date date) {
		this.dateFin = date;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	public Set<Activite> getActivites() {
		return activites;
	}


	public void setActivites(Set<Activite> activites) {
		this.activites = activites;
	}

	
	
}
