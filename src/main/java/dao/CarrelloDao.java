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
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(carrello);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            return false;

        }
    }
}