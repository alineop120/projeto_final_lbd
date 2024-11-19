/**
 * Configuração e criação da conexão com o MySQL
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/banco_malvader"; // URL do banco de dados
    private static final String USER = "root"; // Usuário do banco de dados
    private static final String PASSWORD = ""; // Senha do banco de dados

    // Método para criar e retornar a conexão com o banco
    public static Connection conectar() throws SQLException {
        try {
            // Registrar o driver JDBC MySQL
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Se ocorrer um erro, exibe a mensagem de erro
            System.err.println("Erro de conexão com o banco de dados: " + e.getMessage());
            throw e;
        }
    }

    // Método para fechar a conexão com o banco
    public static void desconectar(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close(); // Fecha a conexão
        }
    }
}
