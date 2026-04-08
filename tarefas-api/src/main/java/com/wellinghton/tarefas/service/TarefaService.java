package com.wellinghton.tarefas.service;

import com.wellinghton.tarefas.model.Tarefa;
import com.wellinghton.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void removerTarefa(Long id) {
        repository.deleteById(id);
    }

    public Tarefa atualizarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }
}