package dao;


import model.RigaOrdine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class RigaOrdineDao {

    public List<RigaOrdine> findByOrdineId(int ordineId) {
        String hql = "FROM RigaOrdine ro WHERE ro.ordine.id = :ordineId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, RigaOrdine.class).setParameter("ordineId", ordineId).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void save(RigaOrdine riga) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(riga);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception rbEx) {
                    rbEx.printStackTrace();
                }
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}




