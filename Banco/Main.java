package Banco;

import java.util.Scanner; import java.util.ArrayList;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasTributadas;
    static ArrayList<Conta> contasCadastradas; 
    public static void main (String[] args){
        contasCadastradas = new ArrayList<Conta>();
        contasTributadas = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("===== BANCO JAVA =====\r\n" + //
                        "1 - Criar conta\r\n" + //
                        "2 - Listar contas\r\n" + //
                        "3 - Depositar\r\n" + //
                        "4 - Sacar\r\n" + //
                        "5 - Transferir\r\n" + //
                        "6 - Consultar saldo\r\n" + 
                        "7 - Calcular tributo de contas correntes\r\n" + //
                        "8 - Autenticar gerente\r\n" + //
                        "0 - Sair"); 

        System.out.println("Escolha uma opção: ");
        int operacao = input.nextInt();

    while (true) {
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                listarContas();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                consultarSaldo();
                break;
            case 7: 
                calcularImpostos();
                break;
            case 8:
                autenticarGerente();
                break;
            case 0:
                System.out.println("Obrigado por usar nossa Agência Bancaria! É ótimo ter você como cliente!");
                System.exit(0);

            default: 
                System.out.println("Opção inválida! Tente novamente.");
                operacoes();
                break;
        }
        if (operacao == 0){
            break;
        } 
        }
    }

    public static void criarConta(){
        System.out.println("Tipos de Conta\r\n" + //
                        "1 - Conta Corrente\r\n" + //
                        "2 - Conta Poupança\r\n");

        System.out.println("\nEscolha um tipo de conta a ser criada: ");
        int tipoDeConta = input.nextInt();
        input.nextLine();

        switch (tipoDeConta) {
            case 1: {
                System.out.println("\nConta do tipo Conta Corrente.");
                System.out.println("\nNome: ");
                String nome = input.nextLine();
                System.out.println("\nCPF: ");
                String cpf = input.nextLine();
                System.out.println("\nEmail: ");
                String email = input.nextLine();

                Pessoa pessoa = new Pessoa(nome, cpf, email);

                Conta contaCorr = new ContaCorrente(pessoa, 0.0);

                contasCadastradas.add(contaCorr);
                contasTributadas.add(contaCorr);

                System.out.println("Conta Corrente criada com sucesso");

                operacoes();
                break;
            }

            case 2: { 
                System.out.println("\nConta do tipo Conta Poupança.");
                System.out.println("\nNome: ");
                String nome = input.nextLine();
                System.out.println("\nCPF: ");
                String cpf = input.nextLine();
                System.out.println("\nEmail: ");
                String email = input.nextLine();

                Pessoa pessoa = new Pessoa(nome, cpf, email);

                Conta contaPoup = new ContaPoupanca(pessoa, 0.0);

                contasCadastradas.add(contaPoup);

                System.out.println("Conta Poupança criada com sucesso");

                operacoes();
                break;
            }

            default:
                System.out.println("Opção Inválida.");
                break;

            
        }

        /*
        System.out.println("\nNome: ");
        String nome = input.next();
        System.out.println("\nCPF: ");
        String cpf = input.next();
        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa, 0.0);

        contasCadastradas.add(conta);

        System.out.println("Conta criada com sucesso");

        operacoes();
        */
    }

    private static Conta encontrarConta(int numConta){
        
        Conta conta = null;
        if (contasCadastradas.size() > 0){ 
            for (Conta c: contasCadastradas){
                if(c.pegarNumConta() == numConta){
                    conta = c;
                }
            }
        }
        return conta;
}

    public static void depositar(){

        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null ) {
            System.out.println("Informe o valor no qual deseja depositar: ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("A conta não foi encontrada");
        }
        operacoes();
    }

    public static void sacar(){

        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Informe o valor no qual deseja sacar: ");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("A conta não foi encontrada");
        } 
        operacoes();
    }

    public static void transferir() {

        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Informe o número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Informe o valor da transferência: ");
                double valorTransferencia = input.nextDouble();
                contaRemetente.transferir(contaDestinatario, valorTransferencia);
            } else {
                System.out.println("A conta destinatária não foi encontrada");

            }

            }else {
                System.out.println("A conta remetente não foi encontrada");
        }
        operacoes();
    }

    public static void listarContas() {

        if (contasCadastradas.size() > 0){
            for (Conta conta: contasCadastradas){
                System.out.println(conta);
            }
        } else {
            System.out.println("Não existem contas cadastradas.");
        }
        operacoes();
    }

    public static void consultarSaldo() {

        System.out.println("Número da Conta: ");
        int numeroConta = input.nextInt();

        Conta contacons = encontrarConta(numeroConta);

        if (contacons != null){
            System.out.println(contacons.pegarSaldo());
        } else {
            System.out.println("A conta não foi encontrada.");
        }
        operacoes();
    }

    public static void autenticarGerente(){
        System.out.println("Digite a senha do gerente: ");
        String senha = input.next();

        Pessoa pessoa = new Pessoa ("Claudio", "90198248102", "ClaudiozinhoDoGrau@gmail.com");
        Gerente gerente = new Gerente(pessoa, "40028922");

        if (gerente.autenticar(senha)){
            System.out.println("Acesso concedido. ");
        } else {
            System.out.println("Acesso negado. Senha incorreta.");
        }
        operacoes();
    }

    public static void calcularImpostos(){
        CalculadoraDeImposto calcdeImpostos = new CalculadoraDeImposto();
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            if (conta instanceof Tributavel){
                double impostoPago = ((Tributavel) conta).calcularTributo();
                System.out.println ("O total de pontos da conta é de: " + impostoPago);
            } else {
                System.out.println("A conta é do tipo poupança, então não paga tributos.");
            }
        } else {
            System.out.println("A conta não foi encontrada.");
        }

        for (Conta c: contasCadastradas){
            if (c instanceof Tributavel){
                calcdeImpostos.registrar((Tributavel) c);
            }
        }

        System.out.println("O Total de Impostos de todas as contas a serem pagos é de: " + calcdeImpostos.pegarImpostos());
        operacoes();
    }


}
