package repository;

import model.Tarefa;
import model.StatusTarefa;

import java.io.*;
import java.util.*;

public class TarefaRepository {
    private final String ARQUIVO = "tarefas.txt";

    public void salvar(List<Tarefa> tarefas) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO));

            for (Tarefa tarefa : tarefas) {
                String linha = tarefa.getId() + ";" +
                        tarefa.getTitulo() + ";" +
                        tarefa.getDescricao() + ";" +
                        tarefa.getStatus() + ";" +
                        tarefa.getDataCriacao();

                writer.write(linha);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas");
        }
    }
 
    public List<Tarefa> carregar() {
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"));
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                Long id = Long.parseLong(partes[0]);
                String titulo = partes[1];
                String descricao = partes[2];
                StatusTarefa status = StatusTarefa.valueOf(partes[3]);

                Tarefa tarefa = new Tarefa(id, titulo, descricao);
                tarefa.setStatus(status);

                tarefas.add(tarefa);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Arquivo de tarefas ainda não existe.");
        }
        

        return tarefas;
    } 
}
