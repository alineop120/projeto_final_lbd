/**
 * Modelo para conta bancária tipo "Poupança"
 */
package model;

public class ContaPoupanca extends Conta {
    // Atributos
    private double taxaRendimento;
    
    // Construtor
    public ContaPoupanca(int numero, String agenda, Double saldo, Cliente cliente, double taxaRendimento) {
        super(numero, agenda, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }
    
    // Getters e Setters
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
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
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + this.saldo);
            return true;  // Retorna true quando o saque é bem-sucedido
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;  // Retorna false quando a operação falha
        }
    }
    
    @Override
    public double consultarSaldo(){
        return this.saldo;  // Retorna o saldo atual da conta
    }
    
    public void calcularRendimento() {
        // Calcula o rendimento com base na taxa de juros
        double rendimento = getSaldo() * (taxaRendimento / 100);
        depositar(rendimento); // O rendimento é depositado na conta
        System.out.println("Rendimento de " + rendimento + " calculado e depositado.");
    }
}
