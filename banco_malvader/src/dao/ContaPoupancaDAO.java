package dao;

import model.ContaPoupanca;
import model.Cliente;
import java.sql.*;

public class ContaPoupancaDAO extends ContaDAO {

    // Método para salvar a conta poupança no banco
    public void save(ContaPoupanca contaPoupanca) throws SQLException {
        String sql = "INSERT INTO conta_poupanca (numero_conta, saldo, taxa_rendimento, cliente_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contaPoupanca.getNumero());
            stmt.setDouble(2, contaPoupanca.getSaldo());
            stmt.setDouble(3, contaPoupanca.getTaxaRendimento());
            stmt.setInt(4, contaPoupanca.getCliente().getId());  // Relacionamento com o cliente

            stmt.executeUpdate();
        }
    }

    // Método para consultar uma conta poupança no banco
    @Override
    public ContaPoupanca findByNumero(int numeroConta) throws SQLException {
        String sql = "SELECT numero_conta, saldo, taxa_rendimento, cliente_id FROM conta_poupanca WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int clienteId = rs.getInt("cliente_id");

                // Recuperar os dados do cliente completo
                Cliente cliente = getClienteById(clienteId);

                // Criar e retornar a conta poupança
                return new ContaPoupanca(
                    rs.getInt("numero_conta"),
                    rs.getDouble("saldo"),
                    cliente, // Cliente recuperado do banco de dados
                    rs.getDouble("taxa_rendimento")
                );
            }
        }

        return null;  // Caso não encontre
    }

    // Método para atualizar uma conta poupança no banco
    public void update(ContaPoupanca contaPoupanca) throws SQLException {
        String sql = "UPDATE conta_poupanca SET saldo = ?, taxa_rendimento = ? WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, contaPoupanca.getSaldo());
            stmt.setDouble(2, contaPoupanca.getTaxaRendimento());
            stmt.setInt(3, contaPoupanca.getNumero());

            stmt.executeUpdate();
        }
    }

    // Método para excluir uma conta poupança no banco
    public void delete(ContaPoupanca contaPoupanca) throws SQLException {
        String sql = "DELETE FROM conta_poupanca WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contaPoupanca.getNumero());

            stmt.executeUpdate();
        }
    }

    private Cliente getClienteById(int clienteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}