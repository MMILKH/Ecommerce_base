package dao;

import model.RigaCarrello;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RigaCarrelloDao {

    public List<RigaCarrello> findByCarrelloId(int carrelloId) {
        List<RigaCarrello> righe = new ArrayList<>();
        String sql = "SELECT * FROM riga_carrello WHERE carrello_id = ? ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, carrelloId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RigaCarrello riga = new RigaCarrello(
                            rs.getInt("id"),
                            rs.getInt("carrello_id"),
                            rs.getInt("prodotto_id"),
                            rs.getInt("quantita"),
                            rs.getString("data_creazione")
                    );
                    righe.add(riga);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return righe;
    }


    public void save(RigaCarrello riga) {

        String newSql = "INSERT INTO riga_carrello (carrello_id, prodotto_id, quantita, data_creazione) VALUES (?, ?, ?, SYSDATE)";
        String checkSql = "SELECT * FROM riga_carrello WHERE carrello_id = ? AND prodotto_id = ?";
        String updateSql = "UPDATE riga_carrello SET quantita = quantita + ? WHERE carrello_id = ? AND prodotto_id = ?";
        boolean prima = true;
        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement pstmt = conn.prepareStatement(checkSql)) {
                pstmt.setInt(1, riga.getCarrelloId());
                pstmt.setInt(2, riga.getProdottoId());
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        prima = false;
                    }
                }

            }

            if (prima) {
                try (PreparedStatement pstmt = conn.prepareStatement(newSql)) {
                    pstmt.setInt(1, riga.getCarrelloId());
                    pstmt.setInt(2, riga.getProdottoId());
                    pstmt.setInt(3, riga.getQuantita());
                    pstmt.executeUpdate();

                }
            } else {
                try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                    pstmt.setInt(1, riga.getQuantita());
                    pstmt.setInt(2, riga.getCarrelloId());
                    pstmt.setInt(3, riga.getProdottoId());
                    pstmt.executeUpdate();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public boolean delete(int carrelloId, int prodottoId) {
        String sql = "DELETE FROM riga_carrello WHERE carrello_id = ? AND prodotto_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, carrelloId);
            pstmt.setInt(2, prodottoId);

            int riuscito = pstmt.executeUpdate();
            return riuscito > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateQuantita(int carrelloId, int prodottoId, int nuovaQuantita) {
        String sql = "UPDATE riga_carrello SET quantita = ? WHERE carrello_id = ? AND prodotto_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nuovaQuantita);
            pstmt.setInt(2, carrelloId);
            pstmt.setInt(3, prodottoId);

            int riuscito = pstmt.executeUpdate();
            return riuscito > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}