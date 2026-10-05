package dao;

import model.Prodotto;
import org.hibernate.Session;
import util.DBConnection;
import util.HibernateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    }

    public boolean save(Prodotto prodotto) {
        String sql = "INSERT INTO prodotto (sku, nome, descrizione_breve, descrizione_estesa, prezzo, immagine, categoria, disponibilita, stato_pub) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, prodotto.getSku());
            pstmt.setString(2, prodotto.getNome());
            pstmt.setString(3, prodotto.getDescrizioneBreve());
            pstmt.setString(4, prodotto.getDescrizioneEstesa());
            pstmt.setDouble(5, prodotto.getPrezzo());
            pstmt.setString(6, prodotto.getImmagine());
            pstmt.setString(7, prodotto.getCategoria());
            pstmt.setInt(8, prodotto.getDisponibilita());
            pstmt.setInt(9, prodotto.getStatoPub());

            int righeInserite = pstmt.executeUpdate();
            return righeInserite > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Prodotto> findByCategoria(String categoria) {
        String sql = "SELECT * FROM prodotto WHERE categoria = ? ORDER BY id";

        List<Prodotto> prodotti = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Prodotto p = new Prodotto(
                            rs.getInt("id"),
                            rs.getString("sku"),
                            rs.getString("nome"),
                            rs.getString("descrizioneB"),
                            rs.getString("descrizioneE"),
                            rs.getDouble("prezzo"),
                            rs.getString("immagine"),
                            rs.getString("categoria"),
                            rs.getInt("disponibilita"),
                            rs.getInt("stato_pub")
                    );
                    prodotti.add(p);


                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodotti;
    }
}


