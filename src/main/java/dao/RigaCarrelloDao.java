package dao;

import model.RigaCarrello;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class RigaCarrelloDao {

    public List<RigaCarrello> findByCarrelloId(int carrelloId) {
        String hql = "FROM RigaCarrello rc WHERE rc.carrello.id = :carrelloId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, RigaCarrello.class).setParameter("carrelloId", carrelloId).list();
        }
    }


    public boolean save(RigaCarrello riga) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(riga);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }


    }


    public boolean delete(int carrelloId, int prodottoId) {
        Transaction tx = null;
        String hql = "From RigaCarrello rc where rc.prodotto.id = :prodottoId and  rc.carrello.id = :carrelloId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            RigaCarrello rc = session.createQuery(hql, RigaCarrello.class).setParameter("carrelloId", carrelloId)
                    .setParameter("prodottoId", prodottoId).uniqueResult();
            if (rc != null) {
                session.delete(rc);
                tx.commit();
                return true;
            } else {
                System.out.println("Riga non trovata");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return false;
    }


//    public boolean svuotaCarrello(int carrelloId) {
//        String sql = "DELETE FROM riga_carrello WHERE carrello_id = ?";
//        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, carrelloId);
//
//            int riuscito = pstmt.executeUpdate();
//            return riuscito > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean updateQuantita(int carrelloId, int prodottoId, int nuovaQuantita) {
        Transaction tx = null;
        String hql = "From RigaCarrello rc Where rc.carrello.id = :carrelloId  and rc.prodotto.id = :prodottoId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            RigaCarrello rc = session.createQuery(hql, RigaCarrello.class).setParameter("carrelloId", carrelloId)
                    .setParameter("prodottoId", prodottoId).uniqueResult();

            if (rc != null) {

                rc.setQuantita(nuovaQuantita);
            }
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

