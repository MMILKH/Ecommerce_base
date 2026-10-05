package dao;

import model.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDateTime;
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

            String hql = "from Utente WHERE email = :email";
            return (Utente) session.createQuery(hql, Utente.class).setParameter("email", email);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(Utente utente) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            utente.setData_creazione(LocalDateTime.now());
            utente.setData_ultima_modifica(LocalDateTime.now());
            session.persist(utente);
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
