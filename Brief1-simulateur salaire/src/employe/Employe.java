package employe;

public class Employe {
	private String nom;
	private String prenom;
	private Double salaire;
	
	//constructeur 1
	public Employe(String n, String p) {
		this.nom = n;
		this.prenom = p;
	}
	//constructeur 2
	public Employe(String n, String p,Double s) {
		this.nom = n;
		this.prenom = p;
		this.salaire = s;
	}
	
	//les accesseurs (getters && setters)
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
	
	public static void main(String[] args) {
		//Instanciation d'un nouvel employe
		Employe E1 = new Employe("Nawan", "Soubape");
		Employe E2 = new Employe("Nawan", "Bienvenue", 10000.0);
		System.out.println("Bonjour "+E1.nom 
				+" "+E1.prenom);
		System.out.println("Bonjour "+E2.nom 
				+" "+E2.prenom +","+ "votre salaire est : "+E2.salaire+ " DHS");
		//Modification du nom et salaire d'un employe
		E2.setNom("Tchando");
		E2.setSalaire(E2.salaire+5000);
		System.out.println("Bonjour "+E2.nom +
				" votre nom a ete bien modifie "
				+ "et votre nouveau salaire est : "+E2.salaire);
		
	}

}
