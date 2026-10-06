package dao;

import model.Carrello;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CarrelloDao {

    public Carrello findByUtenteId(int utenteId) {
        String hql = "FROM Carrello c WHERE c.utente.id = :utenteId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Carrello.class).setParameter("utenteId", utenteId).uniqueResult();
        }

    }

    public boolean save(Carrello carrello) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(carrello);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            return false;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();

            }
        }
    }


    public void updateUltimoAggiornamento(Carrello carrello) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(carrello);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}