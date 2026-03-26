package service;

import java.util.ArrayList;
import java.util.List;

import model.StatusTarefa;
import model.Tarefa;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Long contadorId = 1L;

    public void criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(contadorId, titulo, descricao);
        tarefas.add(tarefa);
        contadorId++;
    }

    public void listarTarefas() {
        if (tarefas.size() == 0) {
            System.out.println("Sem tarefas no momento!");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.println("---------------------");
            System.out.println("ID: " + tarefa.getId());
            System.out.println("Titulo: " + tarefa.getTitulo());
            System.out.println("Status: " + tarefa.getStatus());
            System.out.println("Data: " + tarefa.getDataCriacao());
            System.out.println("---------------------");
        }
    }

    public void atualizarStatus(Long id, StatusTarefa novoStatus) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setStatus(novoStatus);
                System.out.println("Status atualizado!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada");
    }

    public void removerTarefa(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefas.remove(tarefa);
                System.out.println("Tarefa removida!");
            }
        }

        System.out.println("Tarefa não encontrada");
    }
}
