/**
 * Modelo para conta bancária tipo "Poupança"
 */
package model;

public class ContaPoupanca extends Conta {
    //Atributos
    private double taxaRendimento;
    
    //Construtor
    public ContaPoupanca(int numero, String agenda, Double saldo, Cliente cliente, double taxaRendimento) {
        super(numero, agenda, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }
    
    // Get e Set
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
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
    
    public double calcularRendimento() {
        return 0;
        
    }
    
}
