package dao;

import model.Stato;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatoDao {

    public List<Stato> findAll() {
        List<Stato> stati = new ArrayList<>();
        String sql = "SELECT * FROM stato_ordine ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Stato s = new Stato(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descrizione"),
                        rs.getString("codice")
                );
                stati.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stati;
    }

    public Stato findById(int id) {
        String sql = "SELECT * FROM stato_ordine WHERE id = ?";
        Stato stato = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    stato = new Stato(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descrizione"),
                            rs.getString("codice")

                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stato;
    }
}
