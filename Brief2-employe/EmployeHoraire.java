package employe;

import java.util.Date;
import java.text.SimpleDateFormat;   

public class EmployeHoraire extends Employe{
	private int nheure;
	private int thoraire;

	public EmployeHoraire(String nom, String prenom, String date_naissance, int nheure, int thoraire) {
		super(nom, prenom, date_naissance);
		this.nheure = nheure;
		this.thoraire = thoraire;
		// TODO Auto-generated constructor stub
	}
	public Double calculSalaire(int nheure, int thoraire) {
		int salaire = nheure*thoraire;
		 return (double) salaire;
	}
	/**
	 * @return the nheure
	 */
	public int getNheure() {
		return nheure;
	}

	/**
	 * @param nheure the nheure to set
	 */
	public void setNheure(int nheure) {
		this.nheure = nheure;
	}

	/**
	 * @return the thoraire
	 */
	public double getThoraire() {
		return thoraire;
	}

	/**
	 * @param thoraire the thoraire to set
	 */
	public void setThoraire(int thoraire) {
		this.thoraire = thoraire;
	}

	@Override
	public String toString() {
		return super.toString()+"\n\t\t\tNombre d'heure : " + nheure +" Heures"+ "\n\t\t\tTaux horaire : " + thoraire+" DHS"+
				"\n\t\t\tVotre salaire est : "+calculSalaire(nheure, thoraire)+" DHS";
	}
	
	

}
