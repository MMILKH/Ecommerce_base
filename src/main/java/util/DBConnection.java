package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL ="jdbc:oracle:thin:@192.168.8.110:1521:XE";
    private static final String USER = "ecommerce_db";
    private static final String PASS = "password123";


    public static Connection getConnection() throws SQLException {
        try {
            // Carica il driver JDBC di Oracle
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC Oracle non trovato! Verificare le librerie del progetto.");
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

