# ME1-BancoJ

Nome: Kevin Anderson Ferreira da Silva
Matrícula: 2642366
Disciplina: Projeto de Programação
Professor: Amaury Nogueira Neto 

# Explicação da Arquitetura

Explicações:

----------------------------------------------------
- Porque a Classe "Conta" é abstrata?
----------------------------------------------------
A Classe "Conta" tem que ser definida como abstrata pois ela é uma representação de um conceito genérico de conta bancária, servindo como uma "base de esqueleto" gênerico para criação de contas de tipos mais específicos, como, no exemplo da atividade, contas correntes e contas poupança. Então não instanciamos a classe "Conta" diretamente, apenas temos que instanciar as classes filhas: "ContaPoupanca" e "ContaCorrente, pois a Classe "Conta" é a classe mãe que serve como base para as filhas, que herdam seus atributos, metódos e funcionalidades.

Então a Classe "Conta" centraliza comportamentos comuns a todas as contas, como:

depósito
saque
transferência
controle de saldo

As classes filhas "ContaCorrente" e "ContaPoupanca" herdam da Classe mãe "Conta", ou seja, elas reutilizam a lógica e especializando em seus comportamentos.

----------------------------------------------------
- Por que "Tributavel" é uma interface?
----------------------------------------------------

A interface Tributavel teve que ser criada para representar qualquer entidade que possa pagar tributos no sistema. definindo o método:

double calcularTributo();

A vantagem de usar interface é permitir que diferentes classes implementem esse comportamento, mesmo que não tenham relação direta de herança, funciona como uma espécie de "Contrato", onde, cada classe que implementar essa interface deve por obrigação ter o método "calcularTributo()" para que o código possa funcionar. No projeto a classe "ContaCorrente" implementa a interface "Tributavel" pois contas desse tipo pagam tributos, porém a classe "ContaPoupanca" não implementa (pois não paga tributo).

----------------------------------------------------
- Como ocorre o Polimorfismo no cáculo de imposto?
----------------------------------------------------

O polimorfismo ocorre através do uso da interface Tributavel, onde, classe CalculadoraDeImposto recebe qualquer objeto que implemente essa interface:

public void registrar(Tributavel t){
    totalImpostos += t.calcularTributo();
}

Então, no sistema, diferentes objetos são tratados de forma genérica:

if (c instanceof Tributavel){
    calcdeImpostos.registrar((Tributavel) c);
}

Ou seja, não importa o tipo específico da conta, ela pode ser usada no cálculo de impostos, desde que implemente a Interface "Tributavel", no caso do código apresentado, somente contas do tipo conta corrente pagam os tributos.

# Como executar:

Para executar é necessário ter o JDK 8 ou superior instalado no computador, além da JVM (Java Virtual Machine) para rodar o projeto. Também é necessário um terminal ou uma IDE que suporte Java, como o Visual Studio Code. Para executar o sistema, é necessário primeiro compilar os arquivos Java do projeto. Depois, executar a classe Main que está no pacote Banco, no arquivo "Main.java", pois ela contém o método principal que executa o programa. O sistema exibirá no terminal um menu com as operações disponíveis do banco. Então basta somente realizar as operações desejadas disponíveis no programa.

# Funcionalidades implementadas:
- Criar conta
- Listar contas cadastradas
- Depositar valores
- Sacar valores
- Transferir entre contas
- Consultar saldo

# Exemplo de execução:

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
7 - Calcular tributo de contas correntes
8 - Autenticar gerente
0 - Sair

Escolha uma opção:
1

Tipos de Conta
1 - Conta Corrente
2 - Conta Poupança

Escolha um tipo de conta a ser criada:
1

Conta do tipo Conta Corrente.

Nome:
Arthur Morgan

CPF:
12345678900

Email:
ImAfraidSister@gmail.com

Conta Corrente criada com sucesso


===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
7 - Calcular tributo de contas correntes
8 - Autenticar gerente
0 - Sair

Escolha uma opção: 
3

Número da conta: 
1

Informe o valor no qual deseja depositar:
10000

O deposito no valor de 10000 foi realizado com sucesso.
