package com.board.Avanade.board.controller;

import java.util.List;
import java.util.Scanner;

import com.board.Avanade.board.model.Tarefa;
import com.board.Avanade.board.service.TarefaService;

public class TarefaController {
    private TarefaService service = new TarefaService();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n--- Board de Tarefas ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Status");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    atualizarStatus();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarTarefa() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Status (A fazer/Em andamento/Concluído): ");
        String status = scanner.nextLine();
        service.adicionarTarefa(titulo, descricao, status);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void listarTarefas() {
        List<Tarefa> tarefas = service.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    private void atualizarStatus() {
        listarTarefas();
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Novo status (A fazer/Em andamento/Concluído): ");
        String novoStatus = scanner.nextLine();
        service.atualizarStatus(id, novoStatus);
        System.out.println("Status atualizado com sucesso!");
    }

    private void removerTarefa() {
        listarTarefas();
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        service.removerTarefa(id);
        System.out.println("Tarefa removida com sucesso!");
    }
}
