package com.example.veterinaria.controller;


import com.example.veterinaria.dao.ConsultaDAO;
import com.example.veterinaria.model.Consulta;

import java.sql.SQLException;
import java.util.List;

public class ConsultaController {
    private final ConsultaDAO consultaDAO;

    public ConsultaController(ConsultaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;
    }

    public void adicionarConsulta(Consulta consulta) {
        try {
            consultaDAO.adicionarConsulta(consulta);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar consulta: " + e.getMessage());
        }
    }

    public List<Consulta> listarConsultas() {
        try {
            return consultaDAO.listarConsultas();
        } catch (SQLException e) {
            System.out.println("Erro ao listar consultas: " + e.getMessage());
            return null;
        }
    }

    public void atualizarConsulta(Consulta consulta) {
        try {
            consultaDAO.atualizarConsulta(consulta);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar consulta: " + e.getMessage());
        }
    }

    public void excluirConsulta(int id) {
        try {
            consultaDAO.excluirConsulta(id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir consulta: " + e.getMessage());
        }
    }
}

