package Banco;

public class ContaPoupanca extends Conta {

    /*
    private double taxaRendimento = 0.05;
    */
   
    /*
    protected static int contadorDeContasPoup = 1;
    protected int numeroContaPoup; protected Pessoa titularPoup; protected double saldoPoup = 0.0;
    */
   
    public ContaPoupanca(Pessoa titular, double saldoInicial) {
    super(titular, saldoInicial);
    }

    /*

    public Pessoa pegarTitular() {
        return titular;
    }
    public void confirmarTitular(Pessoa titular){
        this.titular = titular;
    }
    public double pegarSaldo() {
        return saldo;
    }
    public void confirmarSaldo(double saldo) {
        this.saldo = saldo;
    }
    */
    
}


/*
class ContaPoupanca extends Conta {

    private double taxaRendimento = 0.05;

    public ContaPoupanca(Pessoa titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        double rendimento = saldo * taxaRendimento;

        saldo += rendimento;

        System.out.println("Rendimento aplicado: " + rendimento);
    }

*/