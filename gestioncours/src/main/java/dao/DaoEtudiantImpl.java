package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Etudiants;
import utils.HibernateUtil;

public class DaoEtudiantImpl implements DaoService<Etudiants> {

	@Override
	public void add(Etudiants etudiant) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(etudiant);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}

	@Override
	public void update(Etudiants o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Etudiants> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiants getOById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeO(int id) {
		// TODO Auto-generated method stub
		
	}

}
