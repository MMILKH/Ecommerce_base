package dao;

import model.Ruolo;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuoloDao {

    public List<Ruolo> findAll() {
        List<Ruolo> ruoli = new ArrayList<>();
        String sql = "SELECT * FROM ruolo ORDER BY id ";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Ruolo r = new Ruolo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descrizione")
                );
                ruoli.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ruoli;
    }

    public Ruolo findById(int id) {
        String sql = "SELECT * FROM ruolo WHERE id = ?";
        Ruolo ruolo = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ruolo = new Ruolo(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descrizione")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ruolo;
    }
}
