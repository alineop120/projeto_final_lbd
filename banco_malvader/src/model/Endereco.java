/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aline.pinho
 */
public class Endereco {
    //Atributos
    private String cep;
    private String local;
    private int numeroCasa;
    private String bairro;
    private String cidade;
    private String estado;

    //Get's e Set's
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //Construtor
    public Endereco(String cep, String local, int numeroCasa, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.local = local;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    //Saida de Dados
    @Override
    public String toString() {
        return "\nCEP: "+cep+
                "\nLocal: "+local+
                "\nNumero da casa: "+numeroCasa+
                "\nBairro: "+bairro+
                "\nCidade: "+cidade+
                "\nEstado: "+estado;
    }
}
