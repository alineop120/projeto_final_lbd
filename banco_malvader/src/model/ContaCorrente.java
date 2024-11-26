/**
 * Modelo para conta bancária tipo "Corrente"
 */
package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
    // Atributos
    private double limite;
    private LocalDate dataVencimento;
    
    // Construtor
    public ContaCorrente(int numero, String agenda, Double saldo, Cliente cliente, double limite, LocalDate dataVencimento) {
        super(numero, agenda, saldo, cliente);
        this.limite = limite;
        this.dataVencimento = dataVencimento;
    }
    
    // Getters e Setters
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
    
    // Métodos
    @Override
    public void depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public boolean sacar(double valor){
        // Verifica se o saque é válido
        if (valor > 0 && valor <= saldo + limite) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + this.saldo);
            return true;  // Saque bem-sucedido
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;  // Falha no saque
        }
    }
    
    @Override
    public double consultarSaldo(){
        // Retorna o saldo disponível considerando o limite
        return this.saldo + this.limite;
    }

    public double consultarLimite() {
        return this.limite;
    }
}