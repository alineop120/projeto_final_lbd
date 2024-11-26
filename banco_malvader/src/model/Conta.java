/**
 * Modelo para conta bancária
 */
package model;

public abstract class Conta {
    //Atributos
    private int numero;
    private String agenda;
    protected static Double saldo;
    private Cliente cliente;

    // Construtor
    public Conta(int numero, String agenda, Double saldo, Cliente cliente) {
        this.numero = numero;
        this.agenda = agenda;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    // Métodos abstratos
    public abstract void depositar(double valor);
    public abstract boolean sacar(double valor);
    public abstract double consultarSaldo();
    
    // Get's e Set's
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
