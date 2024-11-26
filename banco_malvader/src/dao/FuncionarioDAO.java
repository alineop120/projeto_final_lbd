/**
 * Classes para acessar dados do banco e executar consultas e operações de inserção/atualização/exclusão
 */
package dao;

import model.Funcionario;
import java.sql.*;
import java.util.List;

public class FuncionarioDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
     public static List<Funcionario> leTodos() throws Exception
    {
        List<Funcionario> listFuncionarios = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM funcionario";
            connection = ConnectionFactory.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                Funcionario f = new Funcionario();
                f.setInt(rs.getInt("id_funcionario"));
                f.setInt(rs.getString("codigo_funcionario"));
                listFuncionarios.add(f);
            }
            st.close();
            
    //int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String codigoFuncionario, String cargo, String senha, Relatorio relatorio
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return listFuncionarios;
    }
    
    public void save(Funcionario funcionario) throws SQLException {
        // SQL para inserir na tabela 'usuario' e 'funcionario'
        String sqlUsuario = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, 'FUNCIONARIO', ?)";
        String sqlFuncionario = "INSERT INTO funcionario (codigo_funcionario, cargo, id_usuario) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario)) 
        {

            // Inserindo na tabela 'usuario'
            stmtUsuario.setString(1, funcionario.getNome());
            stmtUsuario.setString(2, funcionario.getCpf());
            stmtUsuario.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmtUsuario.setString(4, funcionario.getTelefone());
            stmtUsuario.setString(5, funcionario.getSenha());
            stmtUsuario.executeUpdate();

            // Obtendo o ID do usuário recém-inserido
            ResultSet generatedKeys = stmtUsuario.getGeneratedKeys();
            if (generatedKeys.next()) {
                int usuarioId = generatedKeys.getInt(1);

                // Inserindo na tabela 'funcionario' com o ID do usuario
                stmtFuncionario.setString(1, funcionario.getCodigoFuncionario());
                stmtFuncionario.setString(2, funcionario.getCargo());
                stmtFuncionario.setInt(3, usuarioId);
                stmtFuncionario.executeUpdate();
            } else {
                throw new SQLException("Falha ao obter o ID do usuário inserido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Funcionario consultarDados(int id_Funcionario) throws SQLException {
        String sql = "SELECT id_funcionario, codigo_funcionario, cargo, usuario_id_usuario" +
                     "FROM funcionario " +
                     "WHERE id_funcionario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_Funcionario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Criar o objeto Usuario (nesse caso, como Funcionario)
                Funcionario funcionario = new Funcionario(
                    rs.getInt("id_usuario"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento").toLocalDate(),
                    rs.getString("telefone"),
                    null, // Endereço ainda não disponível
                    rs.getString("codigo_funcionario"),
                    rs.getString("cargo"),
                    rs.getString("senha"),
                    null // Relatório ainda não disponível
                );

                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return null; // Retorna null caso não encontre o funcionário
    }

    
    public void update(Funcionario funcionario) throws SQLException {
        // SQL para atualizar as tabelas 'usuario' e 'funcionario'
        String sqlUsuario = "UPDATE usuario SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, senha = ? WHERE id_usuario = ?";
        String sqlFuncionario = "UPDATE funcionario SET codigo_funcionario = ?, cargo = ? WHERE id_funcionario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario);
             PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario)) {

            // Atualizando na tabela 'usuario'
            stmtUsuario.setString(1, funcionario.getNome());
            stmtUsuario.setString(2, funcionario.getCpf());
            stmtUsuario.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmtUsuario.setString(4, funcionario.getTelefone());
            stmtUsuario.setString(5, funcionario.getSenha());
            stmtUsuario.setInt(6, funcionario.getId());
            stmtUsuario.executeUpdate();

            // Atualizando na tabela 'funcionario'
            stmtFuncionario.setString(1, funcionario.getCodigoFuncionario());
            stmtFuncionario.setString(2, funcionario.getCargo());
            stmtFuncionario.setInt(3, funcionario.getId());
            stmtFuncionario.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void delete(int idFuncionario) throws SQLException {
        // // SQL para deletar as tabelas 'usuario' e 'funcionario'
        String sqlFuncionario = "DELETE FROM funcionario WHERE id_funcionario = ?";
        String sqlUsuario = "DELETE FROM usuario WHERE id_usuario = (SELECT id_usuario FROM funcionario WHERE id_funcionario = ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario);
             PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario)) {

            // Deletando na tabela 'funcionario'
            stmtFuncionario.setInt(1, idFuncionario);
            stmtFuncionario.executeUpdate();

            // Deletando na tabela 'usuario'
            stmtUsuario.setInt(1, idFuncionario);
            stmtUsuario.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


}
