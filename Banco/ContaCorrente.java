package Banco;
public class ContaCorrente {
    protected static int contadorDeContasCorrente = 1;
    protected int numeroContaCorrente; protected Pessoa titularCorr; protected double saldoCorr = 0.0;

    public ContaCorrente (Pessoa titularCorr, double saldoInicialCorr) {
        this.numeroContaCorrente = contadorDeContasCorrente;
        this.titularCorr = titularCorr;
        this.saldoCorr = saldoInicialCorr;
        contadorDeContasCorrente += 1;
    }
    public int pegarNumConta() {
        return numeroContaCorrente;
    }
    public void confirmarNumConta(int numeroConta) {
        this.numeroContaCorrente = numeroConta;
    }
    public Pessoa pegarTitular() {
        return titularCorr;
    }
    public void confirmarTitular(Pessoa titular){
        this.titularCorr = titular;
    }
    public double pegarSaldo() {
        return saldoCorr;
    }
    public void confirmarSaldo(double saldo) {
        this.saldoCorr = saldo;
    }
}
