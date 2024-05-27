package com.example.veterinaria.controller;


import com.example.veterinaria.dao.AnimalDAO;
import com.example.veterinaria.model.Animal;

import java.sql.SQLException;
import java.util.List;

public class AnimalController {
    private final AnimalDAO animalDAO;

    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void adicionarAnimal(Animal animal) {
        try {
            animalDAO.adicionarAnimal(animal);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar animal: " + e.getMessage());
        }
    }

    public List<Animal> listarAnimais() {
        try {
            return animalDAO.listarAnimais();
        } catch (SQLException e) {
            System.out.println("Erro ao listar animais: " + e.getMessage());
            return null;
        }
    }

    public void atualizarAnimal(Animal animal) {
        try {
            animalDAO.atualizarAnimal(animal);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal: " + e.getMessage());
        }
    }

    public void excluirAnimal(int id) {
        try {
            animalDAO.excluirAnimal(id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir animal: " + e.getMessage());
        }
    }
}

