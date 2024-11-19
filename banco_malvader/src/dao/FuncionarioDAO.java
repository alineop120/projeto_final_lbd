/**
 * Classes para acessar dados do banco e executar consultas e operações de inserção/atualização/exclusão
 */
package dao;

import model.Funcionario;
import java.sql.*;

public class FuncionarioDAO {
    private final Connection connection;

    public FuncionarioDAO() throws SQLException {
        this.connection = ConnectionFactory.conectar();
    }

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionarios (codigo, cargo, nome, cpf, data_nascimento, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCodigo());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getNome());
            stmt.setString(4, funcionario.getCpf());
            stmt.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getEndereco().toString());
            stmt.executeUpdate();
        }
    }

    // Outros métodos (consultar, atualizar, deletar)
}

