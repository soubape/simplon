package test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.DaoAdministrateurImpl;
import dao.DaoCoursImpl;
import dao.DaoEtudiantImpl;
import dao.DaoProfesseurImpl;
import entities.Administrateur;
import entities.Cours;
import entities.Etudiants;
import entities.Professeurs;
import utils.HibernateUtil;

public class TestGestion {
	static DaoAdministrateurImpl daoadmin = new DaoAdministrateurImpl();
	static DaoProfesseurImpl daoprof = new DaoProfesseurImpl();
	static DaoEtudiantImpl daoetudiant = new DaoEtudiantImpl();
	static DaoCoursImpl daoecours = new DaoCoursImpl();

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		// creation d'un nouveau professeur
		Professeurs professeur1 = new Professeurs();
		professeur1.setNom("Bienvenue");
		professeur1.setPrenom("Soubape");
		session.save(professeur1);
		
		System.out.println("Inserted professor Successfully");
		//session.getTransaction().commit();
		
		Professeurs professeur2 = new Professeurs();
		professeur2.setNom("Sotima");
		professeur2.setPrenom("Soubape");
		session.save(professeur2);
		System.out.println("Inserted professor Successfully");
		
		Professeurs professeur3 = new Professeurs();
		professeur3.setNom("Ibtihal");
		professeur3.setPrenom("La chinoise");
		session.save(professeur3);
		System.out.println("Inserted professor Successfully");
		//session.getTransaction().commit();
		Professeurs professeur4 = new Professeurs("Leila","Mhaidrat");
		daoprof.add(professeur4);
		
		// creation d'un nouvel administrateur
		Administrateur administrateur1 = new Administrateur();
		administrateur1.setUsername("nawan");
		administrateur1.setPassword("nawan123");
		administrateur1.setEmail("nawan@gmail.com");
		session.save(administrateur1);
		System.out.println("Inserted admin 1 Successfully");
		//session.getTransaction().commit();
		Administrateur administrateur2 = new Administrateur("soubape","soubape456","soubape@gmail.com");
		daoadmin.add(administrateur2);
		System.out.println("Inserted admin 2 Successfully");
		// creation d'un nouveau cours
		Cours cours1 = new Cours();
		cours1.setIntitule("Programmation Oriente Objet");
		cours1.setNomProf(professeur1);
		session.save(cours1);
		System.out.println("Inserted course Successfully");
		
		Cours cours2 = new Cours();
		cours2.setIntitule("Programmation web");
		cours2.setNomProf(professeur2);
		session.save(cours2);
		System.out.println("Inserted course Successfully");
		//session.getTransaction().commit();
		
		Cours cours3 = new Cours();
		cours3.setIntitule("Sciences de l'ingenieur");
		cours3.setNomProf(professeur3);
		session.save(cours3);
		System.out.println("Inserted course Successfully");
		
		// creation d'un nouvel etudiant
		Etudiants etudiants[] = new Etudiants[5];
		etudiants[0] = new Etudiants("Ibtihal","La chinoise");
		session.save(etudiants[0] );
		System.out.println("Inserted course Successfully");
		etudiants[1] = new Etudiants("Soubape","Le beninois");
		session.save(etudiants[1] );
		System.out.println("Inserted course Successfully");
		etudiants[2] = new Etudiants("Abderrahim","Le marocain");
		session.save(etudiants[2] );
		System.out.println("Inserted course Successfully");
		etudiants[3] = new Etudiants("Ayoub","L'ivoirien");
		session.save(etudiants[3] );
		System.out.println("Inserted course Successfully");
		etudiants[4] = new Etudiants("Omar","Le saoudien");
		session.save(etudiants[4] );
		System.out.println("Inserted course Successfully");
		
		//Suppression d'un etudiant
		 Etudiants etudiant4 = (Etudiants)session.load(Etudiants.class, 2);
		  session.delete(etudiant4);
		  System.out.println("Deleted Successfully");
		  
		//Mise a jour d'un etudiant
		 //Etudiants soubape = (Etudiants)session.get(Etudiants.class, 2);
		 //soubape.setNom("Omar");
		 //soubape.setPrenom("DBAA");
		  System.out.println("Updated Successfully");
		//Liste des etudiants
		  @SuppressWarnings("unchecked")
		Query<Etudiants> query = session.createQuery("from Etudiants");
		  List<Etudiants> students = query.list();
		  for(Etudiants etudiant : students)
		  {
			  System.out.println(etudiant.toString());
		  }
		  session.getTransaction().commit();
		  session.close();
		  
		 }
		
		
	}


