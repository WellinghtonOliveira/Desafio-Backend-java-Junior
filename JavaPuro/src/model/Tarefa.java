package model;

import java.time.LocalDate;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private LocalDate dataCriacao;

    public Tarefa(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
        this.dataCriacao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }
}
