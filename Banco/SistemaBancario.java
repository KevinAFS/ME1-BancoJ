package Banco;

public class SistemaBancario {

    public static void main(String[] args) {

        Conta conta1 = new ContaCorrente( Pessoa joao, 1000.0);

        Conta conta2 = new ContaPoupanca( Pessoa maria, 1000.0);

        System.out.println("**** Conta Corrente ***");

        conta1.calcularRendimento();

        conta1.exibirDados();

        System.out.println("\n=== Conta Poupança ===");

        conta2.calcularRendimento();

        conta2.exibirDados();
    }
}