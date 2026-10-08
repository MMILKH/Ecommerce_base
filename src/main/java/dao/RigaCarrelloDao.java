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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RigaCarrello findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(RigaCarrello.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public RigaCarrello findByCIdPId(int carrelloId, int prodottoId) {
        String hql = "FROM RigaCarrello rc WHERE rc.carrello.id = :carrelloId AND rc.prodotto.id = :prodottoId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, RigaCarrello.class).setParameter("carrelloId", carrelloId)
                    .setParameter("prodottoId", prodottoId).uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


    public void save(RigaCarrello riga) {
        Session session = null;
        Transaction tx = null;


        String hql = "FROM RigaCarrello rc WHERE rc.carrello.id = :carrelloId AND rc.prodotto.id = :prodottoId";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            RigaCarrello esistente = session.createQuery(hql, RigaCarrello.class)
                    .setParameter("carrelloId", riga.getCarrello().getId())
                    .setParameter("prodottoId", riga.getProdotto().getId())
                    .uniqueResult();

            if (esistente != null) {

                esistente.setQuantita(esistente.getQuantita() + riga.getQuantita());

            } else {

                session.persist(riga);
            }

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


    public boolean delete(int id) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            RigaCarrello rc = session.get(RigaCarrello.class, id);
            if (rc != null) {
                session.remove(rc);
                tx.commit();
                return true;
            } else {
                System.out.println("Riga non trovata");
                tx.commit();
                return false;
            }
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


    public boolean updateQuantita(int id, int nuovaQuantita) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            RigaCarrello rc = session.get(RigaCarrello.class, id);

            if (rc != null) {
                rc.setUltimaModifica(new java.util.Date());
                rc.setQuantita(nuovaQuantita);
            }

            tx.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception rbEx) {
                    rbEx.printStackTrace();
                }
            }
            return false;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public boolean updateUltimaModifica(int id) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            RigaCarrello rc = session.get(RigaCarrello.class, id);

            if (rc != null) {
                rc.setUltimaModifica(new java.util.Date());
            }

            tx.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (Exception rbEx) {
                    rbEx.printStackTrace();
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

