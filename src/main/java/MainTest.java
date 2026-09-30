

import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("Tentativo di connessione a Oracle Database...");

        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("CONNESSO CON SUCCESSO AD ORACLE!");
                System.out.println("----------------------------------------");

                String sql = "SELECT id, sku, nome, prezzo FROM prodotto";
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    System.out.println("Lista Prodotti trovati nel DB:");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String sku = rs.getString("sku");
                        String nome = rs.getString("nome");
                        double prezzo = rs.getDouble("prezzo");

                        System.out.printf("[%d] %s - %s: €%.2f%n", id, sku, nome, prezzo);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(" ERRORE DI CONNESSIONE:");
            e.printStackTrace();
        }
    }
}
