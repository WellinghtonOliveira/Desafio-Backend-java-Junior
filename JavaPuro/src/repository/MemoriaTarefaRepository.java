package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class MemoriaTarefaRepository implements TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public List<Tarefa> carregar() {
        return tarefas;
    }

}