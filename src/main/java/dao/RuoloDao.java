package dao;

import model.Ruolo;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class RuoloDao {

    public List<Ruolo> findAll() {
        String hql = "FROM Ruolo";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Ruolo.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ruolo findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Ruolo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Ruolo findByNome(String nome) {
        String hql = "FROM Ruolo r WHERE r.nome = :nome";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql,Ruolo.class).setParameter("nome", nome).uniqueResult();
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return null;
    }
}
