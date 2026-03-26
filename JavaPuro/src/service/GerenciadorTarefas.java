package service;

import java.util.ArrayList;
import java.util.List;

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
        for (Tarefa tarefa : tarefas) {
            System.out.println("ID: " + tarefa.getId());
            System.out.println("Titulo: " + tarefa.getTitulo());
            System.out.println("Status: " + tarefa.getStatus());
            System.out.println("Data: " + tarefa.getDataCriacao());
            System.out.println("---------------------");
            
        }
    }
}
