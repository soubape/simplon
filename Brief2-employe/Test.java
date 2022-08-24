package employe;

public class Test {

	public static void main(String[] args) {
		
		//creation d'un employe
		Employe emp1 = new Employe("Nawan", "Soubape", "23/03/1968");
			
		//creation d'un employe fixe
		EmployeFixe empfixe = new EmployeFixe("Tchando", "Victoire", "12/12/1990", 10000.0);
		
		//creation d4un employe commissionnaire
		EmployeCommission empcommission = new EmployeCommission
											("Sagui", "Patrice", "2/01/1980", 100, 0.05, 10000.);
		
		//creation d'un employe a taux horaire
		EmployeHoraire emphoraire = new EmployeHoraire("Tchando", "Victoire", "12/12/1990", 45, 12);
		
		
		//Affichage des employes
		System.out.println("\n**********************************BIENVENUE SUR VOTRE APPLICATION DE GESTION DES EMPLOYES******************************\n");
		System.out.println("\n\t\t=========================EMPLOYE ORDINAIRE================\n");
		System.out.println(emp1);
		System.out.println("\n\t\t=========================EMPLOYE FIXE=====================\n");
		System.out.println(empfixe);
		System.out.println("\n\t\t=========================EMPLOYE COMMISIONNAIRE===========\n");
		System.out.println(empcommission);
		System.out.println("\n\t\t=========================EMPLOYE A TAUX HORAIRE===========\n");
		System.out.println(emphoraire);
	}
	
	
	

}
