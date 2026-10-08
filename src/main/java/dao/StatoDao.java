package dao;

import model.Stato;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class StatoDao {

    public List<Stato> findAll() {
        String hql = "FROM Stato";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Stato.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stato findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Stato.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stato findByCodice(String cod) {
        String hql = "FROM Stato WHERE codice = :codice";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Stato.class).setParameter("codice", cod).uniqueResult();
        }
    }
}
