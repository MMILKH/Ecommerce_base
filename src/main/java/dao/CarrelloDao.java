package dao;

import model.Carrello;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CarrelloDao {

    public Carrello findNewByUtenteId(int utenteId) {
        String hql = "FROM Carrello c WHERE c.utente.id = :utenteId AND c.stato = :stato";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Carrello.class).setParameter("utenteId", utenteId)
                    .setParameter("stato", "NEW").uniqueResult();
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


    public void updateStato(int carrelloId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Carrello c = session.get(Carrello.class, carrelloId);
            c.setUltimoAggiornamento(new java.util.Date());
            c.setStato("COMPLETED");
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