package employe;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Employe {
	private String nom;
	private String prenom;
	private String date_naissance;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param String_naissance
	 */
	public Employe(String nom, String prenom, String date_naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
	}
	
	public Double calculSalaire(Double sal) {
		return sal*1;
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
	 * @return the String_naissance
	 */
	public String getdate_naissance() {
		return date_naissance;
	}

	/**
	 * @param String_naissance the String_naissance to set
	 */
	public void setdate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "\t\t\tBonjour "+nom.toUpperCase() +", voici toutes les informations vous concernant : \n"+"\t\t\tNom : " + nom + "\n\t\t\tPrenom :" + prenom + 
				"\n\t\t\tString de naissance : " + date1;
	}
	
	

}
