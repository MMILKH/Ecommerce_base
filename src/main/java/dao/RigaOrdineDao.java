package dao;

import model.RigaOrdine;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RigaOrdineDao {

    public List<RigaOrdine> findByOrdineId(int ordineId) {
        List<RigaOrdine> righe = new ArrayList<>();
        String sql = "SELECT * FROM riga_ordine WHERE ordine_id = ? ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ordineId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RigaOrdine riga = new RigaOrdine(
                            rs.getInt("ordine_id"),
                            rs.getInt("prodotto_id"),
                            rs.getInt("quantita"),
                            rs.getDouble("prezzo_unitario"),
                            rs.getDouble("prezzo_riga")
                    );
                    riga.setId(rs.getInt("id"));
                    righe.add(riga);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return righe;
    }

    public boolean save(RigaOrdine riga) {
        String sql = "INSERT INTO riga_ordine (prodotto_id, quantita, ordine_id, prezzo_unitario, prezzo_riga) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(3, riga.getOrdineId());
            pstmt.setInt(1, riga.getProdottoId());
            pstmt.setInt(2, riga.getQuantita());
            pstmt.setDouble(4, riga.getPrezzoUnitario());
            pstmt.setDouble(5, riga.getPrezzoRiga());

            int riuscito = pstmt.executeUpdate();
            return riuscito > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
