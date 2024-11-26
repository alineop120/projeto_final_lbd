/**
 * Configuração e criação da conexão com o MySQL
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/db_banco_malvader"; // URL do banco de dados
    private static final String USER = "root"; // Usuário do banco de dados
    private static final String PASSWORD = ""; // Senha do banco de dados

    // Método para criar e retornar a conexão com o banco
    public static Connection getConnection() throws SQLException {
        try {
            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados: " + e.getMessage(), e);
        }
    }

    // Método para fechar a conexão com o banco
    public static void desconectar(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close(); // Fecha a conexão
                }
            } catch (SQLException e) {
                // Logar ou lidar com a exceção de fechamento, caso necessário
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
