package Banco;

public class ContaCorrente extends Conta implements Tributavel{
    /*
    private double taxaManutencao = 20.0;
    */
   
    /*
    protected static int contadorDeContasCorrente = 1;
    protected int numeroContaCorrente; protected Pessoa titularCorr; protected double saldoCorr = 0.0;
    */

    public ContaCorrente (Pessoa titular, double saldoInicial) {
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

    @Override
    public double calcularTributo(){
        return pegarSaldo() * 0.275;
    }
    

    /*
    public void calcularTributo(double valor){
        if (valor > 6000){
            double irpf = pegarSaldo() * 0.275;
            confirmarSaldo(pegarSaldo() - taxaManutencao - irpf);
            System.out.println("Um tributo do IRPF no valor de " + irpf + " foi retirado do seu Saldo.");
        } else {
            System.out.println("Não será declarado o IRPF de acordo com o saldo abaixo dos R$ 6000.");
        }
        
    }
    */

    /*
    @Override
    public void calcularRendimento() {
        saldo -= taxaManutencao;
        System.out.println("Taxa de manutenção descontada: " + taxaManutencao);
    }
    */

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

*/