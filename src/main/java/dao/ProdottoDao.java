package dao;

import model.Prodotto;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDao {

    public List<Prodotto> findAll() {
        List<Prodotto> prodotti = new ArrayList<>();
        String sql = "SELECT * FROM prodotto ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Prodotto p = new Prodotto(
                        rs.getInt("id"),
                        rs.getString("sku"),
                        rs.getString("nome"),
                        rs.getString("descrizioneb"),
                        rs.getString("descrizionee"),
                        rs.getDouble("prezzo"),
                        rs.getString("immagine"),
                        rs.getString("categoria"),
                        rs.getInt("disponibilita"),
                        rs.getInt("stato_pub")
                );
                prodotti.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prodotti;
    }

    public Prodotto findById(int id) {
        String sql = "SELECT * FROM prodotto WHERE id = ?";
        Prodotto prodotto = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    prodotto = new Prodotto(
                            rs.getInt("id"),
                            rs.getString("sku"),
                            rs.getString("nome"),
                            rs.getString("descrizioneb"),
                            rs.getString("descrizionee"),
                            rs.getDouble("prezzo"),
                            rs.getString("immagine"),
                            rs.getString("categoria"),
                            rs.getInt("disponibilita"),
                            rs.getInt("stato_pub")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prodotto;
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
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodotti;
    }
}


