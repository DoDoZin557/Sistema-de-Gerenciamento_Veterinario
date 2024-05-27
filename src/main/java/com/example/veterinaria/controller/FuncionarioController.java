package com.example.veterinaria.controller;

import com.example.veterinaria.dao.FuncionarioDAO;
import com.example.veterinaria.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        try {
            funcionarioDAO.adicionarFuncionario(funcionario);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listarFuncionarios() {
        try {
            return funcionarioDAO.listarFuncionarios();
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
            return null;
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        try {
            funcionarioDAO.atualizarFuncionario(funcionario);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public void excluirFuncionario(int id) {
        try {
            funcionarioDAO.excluirFuncionario(id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }
}
