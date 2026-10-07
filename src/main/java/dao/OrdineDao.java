package dao;

import model.Ordine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class OrdineDao {

    public List<Ordine> findAllByUtenteId(int utenteId) {

        String hql = "FROM Ordine o WHERE o.utente.id = :utenteId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Ordine.class).setParameter("utenteId", utenteId).list();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Ordine> findAll() {

        String hql = "FROM Ordine GROUP BY Ordine.id ";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Ordine.class).list();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }



    public boolean save(Ordine ordine) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(ordine);
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





}
