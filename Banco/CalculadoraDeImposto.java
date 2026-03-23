package Banco;

public class CalculadoraDeImposto {

    private double totalImpostos = 0;

    public void registrar(Tributavel t){
        totalImpostos += t.calcularTributo();

    }

    public double pegarImpostos(){
        return totalImpostos;
    }

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
        */
