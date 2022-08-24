package employe;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class EmployeFixe extends Employe {
	private Double salaire;

	public EmployeFixe(String nom, String prenom, String date_naissance, Double sal) {
		super(nom, prenom, date_naissance);
		this.salaire = sal;
		// TODO Auto-generated constructor stub
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
		return super.toString()+"\n\t\t\tVotre salaire est : " + super.calculSalaire(salaire)+" DHS";
	}

}
