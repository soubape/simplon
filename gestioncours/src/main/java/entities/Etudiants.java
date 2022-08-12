package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="etudiants")
public class Etudiants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@ManyToMany
    @JoinTable( name = "T_Cours_Etudiants_Associations",
                joinColumns = @JoinColumn( name = "IdEtudiant" ),
                inverseJoinColumns = @JoinColumn( name = "IdCours" ) )
    private List<Cours> cours = new ArrayList<>();
	
	public Etudiants() {
	
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	public Etudiants(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	
	/**
	 * @param nom
	 * @param prenom
	 * @param cours
	 */
	public Etudiants(String nom, String prenom, List<Cours> cours) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cours = cours;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	/**
	 * @return the cours
	 */
	public List<Cours> getCours() {
		return cours;
	}

	/**
	 * @param cours the cours to set
	 */
	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiants other = (Etudiants) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append( "ID : " ).append( this.id )
               .append( " Nom : " ).append( this.nom )
               .append( " Prenom : " ).append( this.prenom )
               .append( " Cours suivis : " ).append( this.cours )
               .append( "\n" );
        return builder.toString();
		//return "Etudiants [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
