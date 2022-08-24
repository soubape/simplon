package salaire;

import java.util.Scanner;

public class Simulateur {
	
	
	
	public static void main(String[] args) {
		int mode_paiement;
	    int nheure;
	    Double salaire = 0.0;
		System.out.println("===============================================");
		System.out.println("Entrez votre nom : ");
		Scanner sc1 = new Scanner(System.in);
		String nom = sc1.nextLine();
		System.out.println("Bienvenue "+nom.toUpperCase());
		System.out.println("===============================================");
		System.out.println("Tapez 1 ou 2 pour choisir un mode de paiement : "
					+ "\n 1 - Paiement hebdomadaire \n 2 - Paiement mensuel");
		Scanner sc2= new Scanner(System.in);
		mode_paiement = sc2.nextInt(); 
		
		
		if(mode_paiement==1){
			System.out.println("===============================================");
			System.out.println("Entrez votre tarif horaire > 25 DHS : \n");
			Scanner sc4 = new Scanner(System.in);
			Double tarif = sc4.nextDouble();
			if(tarif <=25) {
				System.out.println("Tarif incorrect "+nom.toUpperCase());
				return;
			
			}
			System.out.println("===============================================");
			System.out.println("Entrez le nombre d'heure hebdomadaire < 50 : \n");
			Scanner sc3 = new Scanner(System.in);
			nheure = sc3.nextInt();
			if(nheure > 50) {
				System.out.println("Nombre d'heure incorrect "+nom.toUpperCase());
				return;
			}
			if(nheure > 40 && nheure <= 50){
				int heure_min = 40;
				int heuresup = nheure-40; 
				salaire = heure_min*tarif+ (heuresup*(tarif+tarif/2));
				System.out.println("===============================================");
				System.out.println("Votre salaire hebdomaire est : "+salaire +" DHS "+nom.toUpperCase()+"\n");
					}
			else {
				salaire = nheure*tarif;
				System.out.println("===============================================");
				System.out.println("Votre salaire hebdomaire est : "+salaire +" DHS "+nom.toUpperCase()+"\n");
					}
			}
			else if(mode_paiement==2){
				System.out.println("===============================================");
				System.out.println("Entrez votre tarif horaire > 20 DHS : \n");
				Scanner sc5 = new Scanner(System.in);
				Double tarif1 = sc5.nextDouble();
				if(tarif1 <=20) {
					System.out.println("Tarif incorrect "+nom.toUpperCase());
					return;
				}	
					
				System.out.println("===============================================");
				System.out.println("Entrez le nombre d'heure mensuel < 200 "+nom.toUpperCase()+"\n");
				Scanner sc3 = new Scanner(System.in);
				nheure = sc3.nextInt();
				if(nheure >= 200) {
					System.out.println("Nombre d'heure incorrect "+nom.toUpperCase());
					return;
				}	
				if(nheure > 180 && nheure <= 200){
					int heure_min = 180;
					int heuresup = nheure-180; 
					salaire = heure_min*tarif1+ (heuresup*(tarif1+tarif1/2));
					System.out.println("===============================================");
					System.out.println("Tarif heure sup = "+(tarif1+tarif1/2));
					System.out.println("Votre salaire mensuel est : "+salaire +" DHS "+nom.toUpperCase()+"\n");
						}
				else {
					salaire = nheure*tarif1;
					System.out.println("===============================================");
					System.out.println("Votre salaire mensuel est : "+salaire +" DHS "+nom.toUpperCase()+"\n");
						}
				}
	System.out.println("===============================================");
	System.out.println("MERCI DE VOTRE FIDELITE "+ nom.toUpperCase() +" !");
}
}



