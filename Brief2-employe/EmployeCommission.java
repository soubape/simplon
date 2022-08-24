package employe;

import java.util.Date;
import java.text.SimpleDateFormat;  
  

public class EmployeCommission extends Employe{
	private int vente;
	private Double commission;
	private Double salaire;

	public EmployeCommission(String nom, String prenom, String date_naissance,
			int vente, Double commission, Double salaire) {
		super(nom, prenom, date_naissance);
		this.vente = vente;
		this.commission = commission;
		this.salaire =salaire;
		// TODO Auto-generated constructor stub
	}

	public Double calculSalaire(int vente, Double commission, Double sal) {
		return (double)vente*commission+super.calculSalaire(sal);
	}
	/**
	 * @return the vente
	 */
	public int getVente() {
		return vente;
	}

	/**
	 * @param vente the vente to set
	 */
	public void setVente(int vente) {
		this.vente = vente;
	}

	/**
	 * @return the commission
	 */
	public Double getCommission() {
		return commission;
	}

	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	

	/**
	 * @return the salaire
	 */
	public Double getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return super.toString()+"\n\t\t\tNombre de vente : " + vente
				+ "\n\t\t\tTaux de Commission : " + 100*commission+" %"
				+"\n\t\t\tVotre salaire de base est : " + super.calculSalaire(salaire)+" DHS"
				+"\n\t\t\tVotre Commission est : " +vente*commission
				+"\n\t\t\tVotre salaire globale est : "
				+calculSalaire(vente, commission, salaire)+" DHS";
	}
	

}
