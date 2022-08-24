package entites;

import java.sql.Date;

public class Produits {
	private String nom;
	private int quantite;
	private double prix;
	private Date dateCreation;
	
	/**
	 * @param nom
	 * @param quantite
	 * @param prix
	 * @param dateCreation
	 */
	public Produits(String nom, int quantite, double prix, Date dateCreation) {

		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.dateCreation = dateCreation;
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
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

}
