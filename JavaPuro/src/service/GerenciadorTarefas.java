package service;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.StatusTarefa;
import model.Tarefa;

import repository.TarefaRepository;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private TarefaRepository repository = new TarefaRepository();
    private Long contadorId = 1L;

    public void criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(contadorId, titulo, descricao);
        tarefas.add(tarefa);
        contadorId++;

        repository.salvar(tarefas);
        System.out.println("Tarefa criada com sucesso!");
    }

    public void salvarTarefas() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tarefas.txt"));

            for (Tarefa tarefa : tarefas) {
                String linha = 
                    tarefa.getId() + ";" +
                    tarefa.getTitulo() + ";" +
                    tarefa.getDescricao() + ";" +
                    tarefa.getStatus() + ";" +
                    tarefa.getDataCriacao();

                writer.write(linha);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas.");
        }
    }

    public void carregarTarefas() {

        tarefas = repository.carregar();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() >= contadorId) {
                contadorId = tarefa.getId() + 1;
            }
        }
        
    }

    public void listarTarefas() {
        ordenarPorData();

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada!");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void atualizarStatus(Long id, StatusTarefa novoStatus) {
        Tarefa tarefa = buscarPorId(id);

        if (tarefa != null) {
            tarefa.setStatus(novoStatus);
            repository.salvar(tarefas);
            System.out.println("Status atualizado!");
        }else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void removerTarefa(Long id) {
        Tarefa tarefa = buscarPorId(id);

        if (tarefa != null) {
            tarefas.remove(tarefa);
            repository.salvar(tarefas);
            System.out.println("Tarefa removida!");
        }else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public Tarefa buscarPorId(Long id) {
        for (Tarefa tarefa : tarefas) {
            return tarefa;
        }

        return null;
    }

    public void buscarPorStatus(StatusTarefa status) {
        boolean encontrou = false;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                System.out.println(tarefa);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada.");
        }
    }

    public void ordenarPorData() {
        Collections.sort(tarefas, Comparator.comparing(Tarefa::getDataCriacao));
    }
}
