package entities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="cours")
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String intitule;
	@ManyToOne
	@JoinColumn(name="IdProfesseur", nullable=false)
	private Professeurs nomProf;
	@ManyToMany
    @JoinTable( name = "T_Cours_Etudiants_Associations",
                joinColumns = @JoinColumn( name = "idCours" ),
                inverseJoinColumns = @JoinColumn( name = "idEtudiant" ) )
    private List<Etudiants> etudiants = new ArrayList<>();
            
	public Cours() {
		
	}

	/**
	 * @param intitule
	 * @param nomProf
	 */
	public Cours(String intitule, Professeurs nomProf) {
		super();
		this.intitule = intitule;
		this.nomProf = nomProf;
	}

	
	/**
	 * @param intitule
	 * @param nomProf
	 * @param etudiants
	 */
	public Cours(String intitule, Professeurs nomProf, List<Etudiants> etudiants) {
		super();
		this.intitule = intitule;
		this.nomProf = nomProf;
		this.etudiants = etudiants;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the nomProf
	 */
	public Professeurs getNomProf() {
		return nomProf;
	}

	/**
	 * @param nomProf the nomProf to set
	 */
	public void setNomProf(Professeurs nomProf) {
		this.nomProf = nomProf;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append( " ID : " ).append( this.id )
        	   .append( "Cours : " ).append( this.intitule )
               .append( " Professeur : " ).append( this.nomProf )
               .append( " Etudiants inscrits : " ).append( this.etudiants )
               .append( "\n" );
        return builder.toString();
	}

	

}
