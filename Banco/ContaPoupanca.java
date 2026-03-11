package Banco;
public class ContaPoupanca {
     protected static int contadorDeContasPoup = 1;
    protected int numeroContaPoup; protected Pessoa titularPoup; protected double saldoPoup = 0.0;

    public ContaPoupanca (Pessoa titularPoup, double saldoInicialPoup) {
        this.numeroContaPoup = contadorDeContasPoup;
        this.titularPoup = titularPoup;
        this.saldoPoup = saldoInicialPoup;
        contadorDeContasPoup += 1;
    }
    public int pegarNumConta() {
        return numeroContaPoup;
    }
    public void confirmarNumConta(int numeroConta) {
        this.numeroContaPoup = numeroConta;
    }
    public Pessoa pegarTitular() {
        return titularPoup;
    }
    public void confirmarTitular(Pessoa titular){
        this.titularPoup = titular;
    }
    public double pegarSaldo() {
        return saldoPoup;
    }
    public void confirmarSaldo(double saldo) {
        this.saldoPoup = saldo;
    }
}
