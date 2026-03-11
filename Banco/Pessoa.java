package Banco;

public class Pessoa {
    protected static int identificador = 1;
    protected String nome; protected String cpf; protected String email;

    public Pessoa (String nome, String cpf, String email) {
        this.nome = nome; this.cpf = cpf; this.email = email;
        identificador += 1;
    }
    public String pegarNome() {
        return nome;
    }
    public void confirmarNome(String nome) {
        this.nome = nome;
    }
    public String pegarCpf(){
        return cpf;
    }
    public void  confirmarCpf(String cpf){
        this.cpf = cpf;
    }
    public String pegarEmail(){
        return email;
    }
    public void confirmarEmail(String email){
        this.email = email;
    }
    public String pessoaCriada(){
        return "\nNome: " + this.pegarNome() +
               "\nCPF: " + this.pegarCpf() +
               "\nEmail: " + this.pegarEmail();
    }
}
