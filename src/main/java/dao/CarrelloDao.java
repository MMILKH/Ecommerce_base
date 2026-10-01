package dao;

import model.Carrello;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarrelloDao {

    public Carrello findByUtenteId(int utenteId) {
        String sql = "SELECT * FROM carrello WHERE utente_id = ?";
        Carrello carrello = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, utenteId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    carrello = new Carrello(
                            rs.getInt("id"),
                            rs.getInt("utente_id"),
                            rs.getString("data_creazione"),
                            rs.getString("ultimo_aggiornamento")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrello;
    }

    public void save(Carrello carrello) {
        String sql = "INSERT INTO carrello (utente_id, data_creazione, ultimo_aggiornamento) VALUES (?, SYSDATE, SYSDATE)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, carrello.getUtenteId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}