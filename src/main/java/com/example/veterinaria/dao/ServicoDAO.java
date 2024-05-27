package com.example.veterinaria.dao;


import com.example.veterinaria.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    private final Connection connection;

    public ServicoDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarServico(Servico servico) throws SQLException {
        String sql = "INSERT INTO servicos (id, nome, preco, id_animal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servico.getId());
            stmt.setString(2, servico.getNome());
            stmt.setBigDecimal(3, servico.getPreco());
            stmt.setInt(4, servico.getAnimalId());
            stmt.executeUpdate();
        }
    }

    public List<Servico> listarServicos() throws SQLException {
        String sql = "SELECT * FROM servicos";
        List<Servico> servicos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Servico servico = new Servico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getBigDecimal("preco"),
                    rs.getInt("id_animal")
                );
                servicos.add(servico);
            }
        }
        return servicos;
    }

    public void atualizarServico(Servico servico) throws SQLException {
        String sql = "UPDATE servicos SET nome = ?, preco = ?, id_animal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setBigDecimal(2, servico.getPreco());
            stmt.setInt(3, servico.getAnimalId());
            stmt.setInt(4, servico.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirServico(int id) throws SQLException {
        String sql = "DELETE FROM servicos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

