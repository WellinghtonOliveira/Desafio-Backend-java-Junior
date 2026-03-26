import service.GerenciadorTarefas;
import java.util.Scanner;

import model.StatusTarefa;

public class Main {
    public static void main(String[] args) throws Exception {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Titulo:");
                    String titulo = scanner.nextLine();

                    System.out.println("Descricao:");
                    String descricao = scanner.nextLine();

                    gerenciador.criarTarefa(titulo, descricao);
                break;
                case 2:
                    gerenciador.listarTarefas();
                break;
                case 3:
                    System.out.println("ID da tarefa:");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Novo status (PENDENTE, EM_ANDAMENTO, CONCLUIDA):");
                    String status = scanner.nextLine();

                    gerenciador.atualizarStatus(id, StatusTarefa.valueOf(status));
                break;
                case 4:
                    System.out.println("ID da tarefa para remover:");
                    Long idRemover = scanner.nextLong();
                    scanner.nextLine();

                    gerenciador.removerTarefa(idRemover);
                break;

                case 5:
                    scanner.close();
                    return;
            }
        }

    }
}
