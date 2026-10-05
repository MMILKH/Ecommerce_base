package dao;

import model.Prodotto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ProdottoDao {

    public List<Prodotto> findAll() {
        String hql = "FROM Prodotto";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Prodotto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Prodotto findById(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Prodotto.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public boolean save(Prodotto prodotto) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(prodotto);
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
            ;
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public List<Prodotto> findByCategoria(String categoria) {
        String hql = "FROM Prodotto WHERE categoria = :categoria";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Prodotto.class).setParameter("categoria", categoria).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}


