package com.example.veterinaria.model;


import java.math.BigDecimal;

public class Servico {
    private int id;
    private String nome;
    private BigDecimal preco;
    private int animalId;

    // Construtor
    public Servico(int id, String nome, BigDecimal preco, int animalId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.animalId = animalId;
    }

    public Servico() {
        //TODO Auto-generated constructor stub
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", animalId=" + animalId +
                '}';
    }
}

