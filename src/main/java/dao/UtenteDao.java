package dao;

import model.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class UtenteDao {

    public List<Utente> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "from Utente";
            return session.createQuery(hql, Utente.class).list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Utente findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Utente.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Utente findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "from Utente u WHERE u.email = :email";
            return session.createQuery(hql, Utente.class).setParameter("email", email).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int save(Utente utente) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            utente.setData_creazione(new java.util.Date());
            utente.setData_ultima_modifica(new java.util.Date());
            session.persist(utente);


            tx.commit();
            return utente.getId();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}
