/**
 * Modelo para conta bancária tipo "Corrente"
 */
package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
    //Atributos
    private double limite;
    private LocalDate dataVencimento;
    
    //Construtor
    public ContaCorrente(int numero, String agenda, Double saldo, Cliente cliente, double limite, LocalDate dataVencimento) {
        super(numero, agenda, saldo, cliente);
        this.limite = limite;
        this.dataVencimento = dataVencimento;
    }
    
    // Get e Set
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    //Metodos
    @Override
    public void depositar(double valor){
        
    }
    @Override
    public boolean sacar(double valor){
        return false;
    
    }
    @Override
    public double consultarSaldo(){
        return 0;
    
    }
    
    public double consultarLimite() {
        return 0;
        
    }

}