package repository;

import model.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(List<Tarefa> tarefas);
    List<Tarefa> carregar();
}