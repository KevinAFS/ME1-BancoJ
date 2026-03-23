package Banco;

public abstract class Funcionario implements Autenticavel {
    /*Atributos */
    protected static int contadordeFuncionario = 1;
    protected int numeroFunc; protected Pessoa pessoa; protected String senha;
    /*Construtor */
    public Funcionario(Pessoa pessoa, String senha){
        this.numeroFunc = contadordeFuncionario;
        this.pessoa = pessoa;
        this.senha = senha;
        contadordeFuncionario += 1;
    }
    /*Metodos Pegar e Confirmar*/
    public int pegarNumFunc(){
        return numeroFunc;
    }
    public void confirmarNumFunc(int numeroFunc){
        this.numeroFunc = numeroFunc;
    }
    public Pessoa pegarPessoa(){
        return pessoa;
    }
    public void confirmarNumFunc(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    public String pegarSenha(){
        return senha;
    }
    public void confirmarSenha(String senha){
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senha){
        return this.senha.equals(senha);
    }



}
