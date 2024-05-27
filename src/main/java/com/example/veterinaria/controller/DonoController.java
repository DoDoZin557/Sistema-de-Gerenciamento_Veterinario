package com.example.veterinaria.controller;

import com.example.veterinaria.dao.DonoDAO;
import com.example.veterinaria.model.Dono;

import java.sql.SQLException;
import java.util.List;

public class DonoController {
    private final DonoDAO donoDAO;

    public DonoController(DonoDAO donoDAO) {
        this.donoDAO = donoDAO;
    }

    public void adicionarDono(Dono dono) {
        try {
            donoDAO.adicionarDono(dono);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar dono: " + e.getMessage());
        }
    }

    public List<Dono> listarDonos() {
        try {
            return donoDAO.listarDonos();
        } catch (SQLException e) {
            System.out.println("Erro ao listar donos: " + e.getMessage());
            return null;
        }
    }

    public void atualizarDono(Dono dono) {
        try {
            donoDAO.atualizarDono(dono);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dono: " + e.getMessage());
        }
    }

    public void excluirDono(int id) {
        try {
            donoDAO.excluirDono(id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dono: " + e.getMessage());
        }
    }
}

