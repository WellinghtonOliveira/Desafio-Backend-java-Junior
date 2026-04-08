package com.wellinghton.tarefas.controller;

import com.wellinghton.tarefas.dto.AtualizarStatusDTO;
import com.wellinghton.tarefas.dto.TarefaDTO;
import com.wellinghton.tarefas.model.Tarefa;
import com.wellinghton.tarefas.service.TarefaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {

        List<Tarefa> tarefas = service.listarTarefas();

        return ResponseEntity.ok(tarefas);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {

        Optional<Tarefa> tarefaOptional = service.buscarPorId(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefaOptional.get());

    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaDTO dto) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus("PENDENTE");
        tarefa.setDataCriacao(LocalDate.now());

        Tarefa novaTarefa = service.criarTarefa(tarefa);

        return ResponseEntity.status(201).body(novaTarefa);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestBody AtualizarStatusDTO dto) {

        Optional<Tarefa> tarefaOptional = service.buscarPorId(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Tarefa tarefa = tarefaOptional.get();

        tarefa.setStatus(dto.getStatus());

        service.atualizarTarefa(tarefa);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {

        Optional<Tarefa> tarefaOptional = service.buscarPorId(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.removerTarefa(id);

        return ResponseEntity.noContent().build();

    }

}















