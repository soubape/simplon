package entities;

import javax.persistence.*;

@Entity
@Table(name="professeurs")
public class Professeurs{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	
	public Professeurs() {

	}

	/**
	 * @param nom
	 * @param prenom
	 */
	public Professeurs(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "ID : " ).append( this.id )
        .append( " Nom : " ).append( this.nom )
        .append( " Prenom : " ).append( this.prenom )
        .append( "\n" );
		return builder.toString();
		//return "Professeurs [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	

}
