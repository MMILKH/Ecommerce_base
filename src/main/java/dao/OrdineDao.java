package dao;

import model.Ordine;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineDao {

    public Ordine findByUtenteId(int utenteId) {
        String sql = "SELECT * FROM ordine WHERE utente_id = ?";
        Ordine ordine = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, utenteId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ordine = new Ordine(
                            rs.getInt("id"),
                            rs.getInt("utente_id"),
                            rs.getInt("stato_id"),
                            rs.getDouble("importo"),
                            rs.getString("indirizzo"),
                            rs.getString("data_creazione")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordine;
    }

    public boolean save(Ordine ordine) {
        String sql = "INSERT INTO ordine (utente_id, data_creazione, importo,indirizzo,stato_id) " +
                "VALUES (?, SYSDATE, ?,?,1)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ordine.getUtenteId());

            pstmt.setDouble(3, ordine.getImportoTotale());
            pstmt.setString(4, ordine.getIndirizzoSpedizione());


            int riuscito = pstmt.executeUpdate();
            return riuscito > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
