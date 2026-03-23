package Banco;

public interface Autenticavel {
    boolean autenticar(String senha);
}

/*
O Scanner massa:

static Scanner input = new Scanner(System.in);

    System.out.println("\nDigite uma senha para autenticação: ");
    String senhaU = input.nextLine();

A propria autenticaão:

if (autenticar(senhaU)){
        System.out.println ("Senha autenticada com Sucesso.");
    } else{
        System.out.println("Não foi possível autenticar sua senha.");
    }

O metodo que autentica a senha, fazendo a verificação por cara caracter

public static boolean autenticar(String senha){

        if (senha.length() < 8){
            return false;

        } 
        boolean letraMaiscula = false;
        boolean letraMinuscula = false;
        boolean caracEspecial = false;
        boolean digito = false;

        for (char c: senha.toCharArray()){
            if (Character.isUpperCase(c)){
                letraMaiscula = true;
            } else if (Character.isLowerCase(c)){
                letraMinuscula = true;
            } else if (Character.isDigit(c)){
                digito = true;
            } else if (!Character.isLetterOrDigit(c)){
                caracEspecial = true;
            }
        }
        return letraMaiscula && letraMinuscula && caracEspecial && digito;
    }
*/