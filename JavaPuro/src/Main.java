import service.GerenciadorTarefas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Sair");

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
                    scanner.close();
                    return;
            }
        }

    }
}
