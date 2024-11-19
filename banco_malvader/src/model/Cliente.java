/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author aline.pinho
 */
public class Cliente extends Usuario {
    //Atributo
    private String senha;

    //Get e Set
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Construtor
    public Cliente (int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String senha) {
        super(id, nome, cpf, dataNascimento, telefone, endereco);
        this.senha = senha;
    }
    
    @Override
    public void login(String senha) {
        
    }
    @Override
    public void logout() {
        
    }
    
    @Override
    public String consultarDados() {
        System.out.println("Classe de consultar dados");
        return null;
    }
    
    public Double consultarSaldo() {
        return null;
        
    }
    
    public void depositar(double valor) {
    
    }
    
    public boolean sacar(double valor) {
        return false;
        
    }
    
    public String consultarExtrato() {
        return null;
        
    }
    
    public double consultarLimite() {
        return 0;
        
    }
}
