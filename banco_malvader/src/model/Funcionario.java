package model;

import java.sql.SQLException;
import java.time.LocalDate;

public class Funcionario extends Usuario {
    // Atributos
    private String codigoFuncionario;
    private String cargo; 
    private String senha;
    private Relatorio relatorio;
    
    // Construtor
    public Funcionario (int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String codigoFuncionario, String cargo, String senha, Relatorio relatorio) {
        super(id, nome, cpf, dataNascimento, telefone, endereco);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo; 
        this.senha = senha;
        this.relatorio = relatorio;
    }
    
    // Métodos 
    @Override
    public void login(String senha) {
        // Verificar se a senha fornecida é igual à armazenada
        if (this.senha.equals(senha)) {
            System.out.println("Login bem-sucedido para " + getNome());
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    @Override
    public void logout() {
        System.out.println(getNome() + " fez logout.");
    }

    @Override
    public String consultarDados() {
        return "Funcionario [Nome: " + getNome() + ", Cargo: " + getCargo() + ", CPF: " + getCpf() + "]";
    }   
    
    public void abrirConta(Conta conta) { 
        // Verifica se a conta é uma ContaCorrente
        if (conta instanceof ContaCorrente) {
            ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();
            try {
                contaDAO.save((ContaCorrente) conta); // Salva a conta corrente no banco
                System.out.println("Conta Corrente aberta com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao abrir conta corrente: " + e.getMessage());
            }
        } 
        // Verifica se a conta é uma ContaPoupanca
        else if (conta instanceof ContaPoupanca) {
            ContaPoupancaDAO contaDAO = new ContaPoupancaDAO();
            try {
                contaDAO.save((ContaPoupanca) conta); // Salva a conta poupança no banco
                System.out.println("Conta Poupança aberta com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao abrir conta poupança: " + e.getMessage());
            }
        } else {
            System.out.println("Tipo de conta não reconhecido.");
        }
    }

    public void encerrarConta(Conta conta) {
        // Verifica se a conta é uma ContaCorrente
        if (conta instanceof ContaCorrente) {
            ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();
            try {
                contaDAO.delete((ContaCorrente) conta); // Exclui a conta corrente no banco
                System.out.println("Conta Corrente encerrada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conta corrente: " + e.getMessage());
            }
        }
        // Verifica se a conta é uma ContaPoupanca
        else if (conta instanceof ContaPoupanca) {
            ContaPoupancaDAO contaDAO = new ContaPoupancaDAO();
            try {
                contaDAO.delete((ContaPoupanca) conta); // Exclui a conta poupança no banco
                System.out.println("Conta Poupança encerrada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conta poupança: " + e.getMessage());
            }
        } else {
            System.out.println("Tipo de conta não reconhecido.");
        }
    }

    public Conta consultarDadosConta(int numeroConta){
        return null;
    
    } 

    public Cliente consultarDadosCliente(int idCliente){
        return null;
    
    } 

    public void alterarDadosConta(Conta conta){
    
    } 

    public void alterarDadosCliente(Cliente cliente){
    
    } 

    public void cadastrarFuncionario(Funcionario funcionario){
    
    } 

    public void gerarRelatorioMovimentacao(){
    
    }
    
    // Get's e Set's
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

}
