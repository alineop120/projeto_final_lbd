package model;

import java.time.LocalDateTime;
import java.util.List;

public class Relatorio {
    // Atributos
    private String tipo;
    private LocalDateTime dataGeracao;
    private List<String> dados;
    
    //Construtor 
    public Relatorio(String tipo, LocalDateTime dataGeracao, List<String> dados) {
        this.tipo = tipo;
        this.dataGeracao = dataGeracao;
        this.dados = dados;
    }
    
    //Get's e Set's
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public List<String> getDados() {
        return dados;
    }

    // Métodos
    public void setDados(List<String> dados) {
        this.dados = dados;
    }
    
    public void gerarRelatorioGeral() {
    
    }
    
    public void exportarparaExcel() {
    
    }

}
