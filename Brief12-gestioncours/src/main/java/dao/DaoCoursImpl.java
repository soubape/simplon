package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Cours;
import utils.HibernateUtil;

public class DaoCoursImpl implements DaoService<Cours> {

	@Override
	public void add(Cours cours) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(cours);
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
	public void update(Cours o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cours> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cours getOById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeO(int id) {
		// TODO Auto-generated method stub
		
	}

}
