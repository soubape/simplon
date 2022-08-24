package entites;

public class Categories {
	private String nom;
	private String Createur;
	/**
	 * @param nom
	 * @param createur
	 */
	public Categories(String nom, String createur) {
		super();
		this.nom = nom;
		Createur = createur;
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
	 * @return the createur
	 */
	public String getCreateur() {
		return Createur;
	}
	/**
	 * @param createur the createur to set
	 */
	public void setCreateur(String createur) {
		Createur = createur;
	}
	
	

}
