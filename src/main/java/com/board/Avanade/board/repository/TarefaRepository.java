package com.board.Avanade.board.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.board.Avanade.board.model.Tarefa;

public class TarefaRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/board_tarefas";
    private static final String USER = "root"; // Substitua pelo seu usuário
    private static final String PASSWORD = "sua_senha"; // Substitua pela sua senha

    // Adiciona uma tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, status, data_criacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao()));
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tarefa.setId((long) rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status")
                );
                Long id = 0L;
                tarefa.setId(id);
                int id1 = rs.getInt("id");
                tarefa.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    public void atualizarStatus(int id, String novoStatus) {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerTarefa(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

