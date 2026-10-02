package dao;

import model.Carrello;
import model.Utente;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDao {

    public List<Utente> findAll() {
        List<Utente> utenti = new ArrayList<>();
        String sql = "SELECT * FROM utente ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Utente u = new Utente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("numero"),
                        rs.getString("indirizzo"),
                        rs.getInt("ruolo_id"),
                        rs.getString("passwordU"),
                        rs.getString("data_creazione"),
                        rs.getString("data_ultima_modifica")
                );
                utenti.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utenti;
    }

    public Utente findById(int id) {
        String sql = "SELECT * FROM utente WHERE id = ?";
        Utente utente = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    utente = new Utente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            rs.getString("email"),
                            rs.getString("numero"),
                            rs.getString("indirizzo"),
                            rs.getInt("ruolo_id"),
                            rs.getString("passwordU"),
                            rs.getString("data_creazione"),
                            rs.getString("data_ultima_modifica")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utente;
    }

    public Utente findByEmail(String email) {
        String sql = "SELECT * FROM utente WHERE email = ?";
        Utente utente = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    utente = new Utente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            rs.getString("email"),
                            rs.getString("numero"),
                            rs.getString("indirizzo"),
                            rs.getInt("ruolo_id"),
                            rs.getString("passwordU"),
                            rs.getString("data_creazione"),
                            rs.getString("data_ultima_modifica")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utente;
    }

    public boolean save(Utente utente) {
        String sql = "INSERT INTO utente (nome, cognome, email, numero, indirizzo, ruolo_id, passwordU, data_creazione,data_ultima_modifica)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?,SYSDATE,SYSDATE)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, utente.getNome());
            pstmt.setString(2, utente.getCognome());
            pstmt.setString(3, utente.getEmail());
            pstmt.setString(4, utente.getNumero());
            pstmt.setString(5, utente.getIndirizzo());
            pstmt.setInt(6, utente.getRuoloId());
            pstmt.setString(7, utente.getPassword());


            int riuscita = pstmt.executeUpdate();
            return riuscita > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(Utente utente) {


        String sql = "INSERT INTO utente (nome, cognome, email, numero, indirizzo, passwordU, data_creazione,data_ultima_modifica)" +
                " VALUES (?, ?, ?, ?, ?, ?,SYSDATE,SYSDATE)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, utente.getNome());
            pstmt.setString(2, utente.getCognome());
            pstmt.setString(3, utente.getEmail());
            pstmt.setString(4, utente.getNumero());
            pstmt.setString(5, utente.getIndirizzo());
            pstmt.setString(6, utente.getPassword());

            int riuscita = pstmt.executeUpdate();

            if (riuscita > 0) {

                Utente utenteAS = findByEmail(utente.getEmail());
                CarrelloDao carrelloDao = new CarrelloDao();
                Carrello carrello = new Carrello(utenteAS.getId());
                carrelloDao.save(carrello);
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
