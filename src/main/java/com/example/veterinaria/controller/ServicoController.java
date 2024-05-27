package com.example.veterinaria.controller;

import com.example.veterinaria.dao.ServicoDAO;
import com.example.veterinaria.model.Servico;

import java.sql.SQLException;
import java.util.List;

public class ServicoController {
    private final ServicoDAO servicoDAO;

    public ServicoController(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public void adicionarServico(Servico servico) {
        try {
            servicoDAO.adicionarServico(servico);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar serviço: " + e.getMessage());
        }
    }

    public List<Servico> listarServicos() {
        try {
            return servicoDAO.listarServicos();
        } catch (SQLException e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
            return null;
        }
    }

    public void atualizarServico(Servico servico) {
        try {
            servicoDAO.atualizarServico(servico);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
        }
    }

    public void excluirServico(int id) {
        try {
            servicoDAO.excluirServico(id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
        }
    }
}

