package model;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    // Atributos
    private String codigoFuncionario;
    private String cargo; 
    private String senha;
    private Relatorio relatorio;
    
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
    public void login(String senha){
    
    }
    @Override
    public void logout(){
    
    }
    
    @Override
    public String consultarDados(){
        return null;
    
    }
    
    public void abrirConta(Conta conta){
        
    }

    public void encerrarConta(Conta conta){
    
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

}
