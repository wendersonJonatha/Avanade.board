package com.board.Avanade.board.service;


import java.util.List;

import com.board.Avanade.board.model.Tarefa;
import com.board.Avanade.board.repository.TarefaRepository;

public class TarefaService {
    private TarefaRepository repository = new TarefaRepository();

    public void adicionarTarefa(String titulo, String descricao, String status) {
        Tarefa tarefa = new Tarefa(titulo, descricao, status);
        repository.adicionarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listarTarefas();
    }

    public void atualizarStatus(int id, String novoStatus) {
        repository.atualizarStatus(id, novoStatus);
    }

    public void removerTarefa(int id) {
        repository.removerTarefa(id);
    }
}
