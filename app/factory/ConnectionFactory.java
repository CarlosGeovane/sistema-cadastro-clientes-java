package app.factory; // Note o package ajustado para o seu projeto

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_clientes";
    private static final String USER = "root";
    private static final String PASS = ""; // Coloque sua senha aqui se tiver

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}