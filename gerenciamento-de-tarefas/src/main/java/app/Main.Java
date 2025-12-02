package app;

import service.TarefaService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import model.Tarefa;

public class Main {
    private static TarefaService service = new TarefaService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1 -> cadastrarTarefa();
                case 2 -> listarTarefas();
                case 3 -> atualizarTarefa();
                case 4 -> excluirTarefa();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gerenciamento de Tarefas ===");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Atualizar tarefa");
        System.out.println("4 - Excluir tarefa");
        System.out.println("5 - Sair");
    }

    private static void cadastrarTarefa() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        LocalDate dataConclusao = lerData("Data de conclusão (YYYY-MM-DD): ");
        service.cadastrarTarefa(titulo, descricao, dataConclusao);
    }

    private static void listarTarefas() {
        List<Tarefa> tarefas = service.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    private static void atualizarTarefa() {
        int id = lerInteiro("ID da tarefa a ser atualizada: ");
        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();
        LocalDate dataConclusao = lerData("Nova data de conclusão (YYYY-MM-DD): ");
        if (service.atualizarTarefa(id, titulo, descricao, dataConclusao)) {
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void excluirTarefa() {
        int id = lerInteiro("ID da tarefa a ser excluída: ");
        if (service.excluirTarefa(id)) {
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static int lerInteiro(String mensagem) {
        int valor = -1;
        while (true) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
        return valor;
    }

    private static LocalDate lerData(String mensagem) {
        LocalDate data = null;
        while (true) {
            try {
                System.out.print(mensagem);
                data = LocalDate.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato YYYY-MM-DD.");
            }
        }
        return data;
    }
}
