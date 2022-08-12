package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Administrateur;
import utils.HibernateUtil;


public class DaoAdministrateurImpl implements DaoService<Administrateur> {

	@Override
	public void add(Administrateur admin) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(admin);
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
	public void update(Administrateur o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrateur> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrateur getOById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeO(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
