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
                            rs.getInt("id"),
                            rs.getInt("ordine_id"),
                            rs.getInt("prodotto_id"),
                            rs.getString("sku"),
                            rs.getString("nome_prodotto"),
                            rs.getInt("quantita"),
                            rs.getDouble("prezzo_unitario"),
                            rs.getDouble("prezzo_riga")
                    );
                    righe.add(riga);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return righe;
    }

    public boolean save(RigaOrdine riga) {
        String sql = "INSERT INTO riga_ordine (ordine_id, prodotto_id, sku, nome_prodotto, quantita, prezzo_unitario, prezzo_riga) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, riga.getOrdineId());
            pstmt.setInt(2, riga.getProdottoId());
            pstmt.setString(3, riga.getSku());
            pstmt.setString(4, riga.getNomeProdotto());
            pstmt.setInt(5, riga.getQuantita());
            pstmt.setDouble(6, riga.getPrezzoUnitario());
            pstmt.setDouble(7, riga.getPrezzoRiga());

            int riuscito = pstmt.executeUpdate();
            return riuscito > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
