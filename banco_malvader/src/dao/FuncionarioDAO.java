package dao;

import model.Funcionario;
import java.sql.*;

public class FuncionarioDAO {
    private final Connection connection;

    public FuncionarioDAO() throws SQLException {
        this.connection = ConnectionFactory.getConection();
    }

    // Operação: Selecionar
    public void List<Funcionario> leTodos() throws SQLException {
        List<Funcinario> listFuncionarios = new ArrayList<Funcionario>();
        try 
        {
            String sql = "SELECT * FROM FUNCIONARIO";
            connection = ConnectionFactory.getConection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                Funcionario f = new Funcionario();
                f.setCodigoFuncionario(rs.getString("codFun"));
                f.setCargo(rs.getString("cargo"));
                listFuncionarios.add(f);
            }
            st.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return listFuncionarios;
    }
    
    // Operação: Inserção
    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (codigo_funcionario, cargo, senha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCodigoFuncionario());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getSenha());
            stmt.executeUpdate();
        }
    }

    // Operação: Atualização
    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET cargo = ?, senha = ? WHERE codigo_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCargo());
            stmt.setString(2, funcionario.getSenha());
            stmt.setString(3, funcionario.getCodigoFuncionario());
            stmt.executeUpdate();
        }
    }

    // Operação: Exclusão
    public void excluirFuncionario(String codigoFuncionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE codigo_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigoFuncionario);
            stmt.executeUpdate();
        }
    }
}
