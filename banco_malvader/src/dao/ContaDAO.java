package dao;

import model.Conta;
import model.Cliente;
import java.sql.*;

public abstract class ContaDAO {

    // Método genérico para salvar a conta (comum a todos os tipos de conta)
    public void save(Conta conta) throws SQLException {
        String sql = "INSERT INTO conta (numero_conta, saldo, cliente_id) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getCliente().getId());  // Relacionamento com o cliente

            stmt.executeUpdate();
        }
    }

    // Método genérico para consultar uma conta por número de conta (comum a todos os tipos de conta)
    public Conta findByNumero(int numeroConta) throws SQLException {
        String sql = "SELECT numero_conta, saldo, cliente_id FROM conta WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int clienteId = rs.getInt("cliente_id");

                // Agora vamos buscar o cliente a partir do cliente_id
                Cliente cliente = getClienteById(clienteId);

                // Retorna uma instância de Conta, associando o cliente recuperado
                return new Conta(
                    rs.getInt("numero_conta"),
                    rs.getDouble("saldo"),
                    cliente  // Cliente recuperado do banco de dados
                ) {
                    @Override
                    public void depositar(double valor) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public boolean sacar(double valor) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public double consultarSaldo() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            }
        }

        return null;  // Caso não encontre
    }
    
    // Método auxiliar para recuperar o Cliente usando o cliente_id
    private Cliente getClienteById(int clienteId) throws SQLException {
        String sql = "SELECT id, nome, cpf, data_nascimento, telefone, endereco FROM cliente WHERE id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento").toLocalDate(),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("senha")
                );
            }
        }

        return null;  // Caso não encontre o cliente
    }

    // Método genérico para atualizar uma conta (comum a todos os tipos de conta)
    public void update(Conta conta) throws SQLException {
        String sql = "UPDATE conta SET saldo = ? WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, conta.getSaldo());
            stmt.setInt(2, conta.getNumero());

            stmt.executeUpdate();
        }
    }

    // Método genérico para excluir uma conta (comum a todos os tipos de conta)
    public void delete(Conta conta) throws SQLException {
        String sql = "DELETE FROM conta WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());

            stmt.executeUpdate();
        }
    }
}