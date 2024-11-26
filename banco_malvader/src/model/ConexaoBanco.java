package model;

import java.sql.Connection;

public class ConexaoBanco {
    //Atributos
    private String url;
    private String usuario;
    private String senha;
    
    //Construtor
    public ConexaoBanco(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    //Get's e Set's
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Métodos
    public Connection conectar() {
        return null;
    
    }
    
    public void desconectar() {
    
    }
}
