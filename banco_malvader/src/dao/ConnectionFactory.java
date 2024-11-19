/**
 * Configuração e criação da conexão com o MySQL
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    protected static String driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/?user=root"; // URL do banco de dados
    private static final String USER = "root"; // Usuário do banco de dados
    private static final String PASSWORD = "c@tolic@"; // Senha do banco de dados

    // Método para criar e retornar a conexão com o banco
    public static Connection getConection() {
        try {
            // Registrar o driver JDBC MySQL
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

}
