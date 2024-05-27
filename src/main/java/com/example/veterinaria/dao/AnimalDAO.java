package com.example.veterinaria.dao;


import com.example.veterinaria.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private final Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animais (id, nome, especie, raca, idade, dono_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, animal.getId());
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getNome());
            stmt.setString(4, animal.getRaca());
            stmt.setInt(5, animal.getIdade());
            stmt.setInt(6, animal.getDonoId());
            stmt.executeUpdate();
        }
    }

    public List<Animal> listarAnimais() throws SQLException {
        String sql = "SELECT * FROM animais";
        List<Animal> animais = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Animal animal = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("especie"),rs.getString("raca"), rs.getInt("idade"), rs.getInt("dono_id"));
                animais.add(animal);
            }
        }
        return animais;
    }

    public void atualizarAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE animais SET nome = ?, raca = ?, idade = ?, dono_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setInt(3, animal.getIdade());
            stmt.setInt(4, animal.getDonoId());
            stmt.setInt(5, animal.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirAnimal(int id) throws SQLException {
        String sql = "DELETE FROM animais WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

