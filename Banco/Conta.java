package Banco;

public abstract class Conta {
    /*Atributos*/
    protected static int contadorDeContas = 1;
    protected int numeroConta; protected Pessoa titular; protected double saldo = 0.0;
    /*Construtor*/
    public Conta(Pessoa titular, double saldoInicial) {
        this.numeroConta = contadorDeContas;
        this.titular = titular;
        this.saldo = saldoInicial;
        contadorDeContas += 1;
    }
    /*Metodos Pegar e Confirmar*/
    public int pegarNumConta() {
        return numeroConta;
    }
    public void confirmarNumConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
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

    /*Metodos da classe*/

    /*Exibir Dados*/
    public String exibirDados() {
        return "\nNúmero da conta: " + this.pegarNumConta() +
               "\nTitular: " + this.titular.pegarNome() +
               "\nCPF: " + this.titular.pegarCpf() +
               "\nEmail: " + this.titular.pegarEmail() +
               "\nSaldo: " + utilitarios.Utils.doubleParaString(this.pegarSaldo()) +
               "\n";
    }
    
    /*Depositar*/
    public void depositar(double valor) {
        if (valor > 0){
            confirmarSaldo(pegarSaldo() + valor);
            System.out.println("O deposito no valor de " + valor + " foi realizado com sucesso.");
        } else {
            System.out.println("O valor do deposito deve ser maior que 0, tente novamente.");
        }
    }

    /*Sacar*/
    public void sacar(double valor) {
        if (valor > 0){
            if (valor <= this.pegarSaldo()) {
                confirmarSaldo(pegarSaldo() - valor);
                System.out.println("O saque no valor de " + valor + "foi realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
        } else {
            System.out.println("O valor do saque deve ser maior que 0, tente novamente.");
        }
    }

    /*Transferir*/
    public void transferir(Conta contaParaDeposito, double valor){
        if (valor > 0){
                if (valor <= this.pegarSaldo()){
                    confirmarSaldo(pegarSaldo() - valor);
                    contaParaDeposito.saldo = contaParaDeposito.pegarSaldo() + valor;
                    System.out.println("A transferência no valor de " + valor + "foi realizada com sucesso.");
                }
        } else {
            System.out.println("O valor da transferência deve ser maior que 0, tente novamente.");
        }
    }


    /*Calcular rendimento*/
    public void calcularRendimento() {
        System.out.println("Conta comum não possui rendimento específico.");
    }


/* 
class ContaCorrente extends Conta {

    private double taxaManutencao = 20.0;

    // Construtor
    public ContaCorrente(Pessoa titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        saldo -= taxaManutencao;
        System.out.println("Taxa de manutenção descontada: " + taxaManutencao);
    }
}

}

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
    }
