import service.GerenciadorTarefas;
import java.util.Scanner;

import model.StatusTarefa;

public class Main {
    public static void main(String[] args) throws Exception {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        gerenciador.carregarTarefas();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Buscar tarefas por status");
            System.out.println("6 - Sair");

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

                    try {
                        StatusTarefa novoStatus = StatusTarefa.valueOf(status.toUpperCase());
                        gerenciador.atualizarStatus(id, novoStatus);

                    }catch (IllegalArgumentException e) {
                        System.out.println("Status inválido.");
                    };

                break;
                case 4:
                    System.out.println("ID da tarefa para remover:");
                    Long idRemover = scanner.nextLong();
                    scanner.nextLine();

                    gerenciador.removerTarefa(idRemover);
                break;

                case 5:
                    System.out.println("Digite o status (PENDENTE, EM_ANDAMENTO, CONCLUIDA):");
                    String statusBusca = scanner.nextLine();

                    try {
                        StatusTarefa stato = StatusTarefa.valueOf(statusBusca.toUpperCase());
                        gerenciador.buscarPorStatus(stato);
                    } catch ( IllegalArgumentException e) {
                        System.out.println("Status invalído");
                    }
                break;

                case 6:
                    scanner.close();
                    return;
            }
        }

    }
}
