package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Professeurs;
import utils.HibernateUtil;

public class DaoProfesseurImpl implements DaoService<Professeurs> {

	@Override
	public void add(Professeurs prof) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(prof);
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
	public void update(Professeurs o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professeurs> list() {
		return null;
		
	}

	@Override
	public Professeurs getOById(int id) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get Student entity using get() method
            Professeurs prof = session.get(Professeurs.class, id);
            System.out.println(prof.getNom());
            System.out.println(prof.getPrenom());

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
	}
		return null;
	}

	@Override
	public void removeO(int id) {
		// TODO Auto-generated method stub
		
	}

}
