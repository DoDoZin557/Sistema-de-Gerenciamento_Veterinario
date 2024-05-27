package com.example.veterinaria.dao;


import com.example.veterinaria.model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private final Connection connection;

    public ConsultaDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarConsulta(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consultas (id, data_consulta, hora_consulta, animal_id, funcionario_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getId());
            stmt.setDate(2, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setTime(3, new java.sql.Time(consulta.getHoraConsulta().getTime()));
            stmt.setInt(4, consulta.getAnimalId());
            stmt.setInt(5, consulta.getFuncionarioId());
            stmt.executeUpdate();
        }
    }

    public List<Consulta> listarConsultas() throws SQLException {
        String sql = "SELECT * FROM consultas";
        List<Consulta> consultas = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta consulta = new Consulta(
                    rs.getInt("id"),
                    rs.getDate("data_consulta"),
                    rs.getTime("hora_consulta"),
                    rs.getInt("animal_id"),
                    rs.getInt("funcionario_id")
                );
                consultas.add(consulta);
            }
        }
        return consultas;
    }

    public void atualizarConsulta(Consulta consulta) throws SQLException {
        String sql = "UPDATE consultas SET data_consulta = ?, hora_consulta = ?, animal_id = ?, funcionario_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setTime(2, new java.sql.Time(consulta.getHoraConsulta().getTime()));
            stmt.setInt(3, consulta.getAnimalId());
            stmt.setInt(4, consulta.getFuncionarioId());
            stmt.setInt(5, consulta.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirConsulta(int id) throws SQLException {
        String sql = "DELETE FROM consultas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

