package com.stc.management.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name="exercice")
public class Exercice {
	@Id
	@Column(name="id_activite")
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

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "exercice")
//	private List<Activite> activites = new ArrayList<Activite>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_exercice", referencedColumnName = "id_activite")
	List<Activite> activites = new ArrayList<>();

	
	
	public Exercice(int annee, Date dateDebut, Date dateFin, boolean statut, List<Activite> activites) {
		super();
		this.annee = annee;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.statut = statut;
		this.activites = activites;
	}

	public Exercice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
