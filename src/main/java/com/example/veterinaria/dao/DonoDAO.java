package com.example.veterinaria.dao;


import com.example.veterinaria.model.Dono;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonoDAO {
    private final Connection connection;

    public DonoDAO(Connection connection ) {
        this.connection = connection;
    }

    public void adicionarDono(Dono dono) throws SQLException {
        String sql = "INSERT INTO donos (id, nome, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dono.getId());
            stmt.setString(2, dono.getNome());
            stmt.setString(3, dono.getEndereco());
            stmt.setString(4, dono.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Dono> listarDonos() throws SQLException {
        String sql = "SELECT * FROM donos";
        List<Dono> donos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Dono dono = new Dono(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
                donos.add(dono);
            }
        }
        return donos;
    }

    public void atualizarDono(Dono dono) throws SQLException {
        String sql = "UPDATE donos SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dono.getNome());
            stmt.setString(2, dono.getEndereco());
            stmt.setString(3, dono.getTelefone());
            stmt.setInt(4, dono.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirDono(int id) throws SQLException {
        String sql = "DELETE FROM donos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

