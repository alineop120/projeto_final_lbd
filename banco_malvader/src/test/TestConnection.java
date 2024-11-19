package test;

import java.sql.Connection;
import java.sql.SQLException;
import dao.ConnectionFactory;

public class TestConnection {

    public static void main(String[] args) {
        try {
            // Tenta conectar ao banco de dados
            Connection connection = ConnectionFactory.conectar();
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                connection.close(); // Fecha a conexão
            }
        } catch (SQLException e) {
            // Se houver erro, exibe a mensagem de erro
            System.err.println("Erro de conexão: " + e.getMessage());
        }
    }
}

