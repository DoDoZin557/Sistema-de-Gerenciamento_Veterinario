package com.example.veterinaria.model;

import java.util.Date;

public class Consulta {
    private int id;
    private Date dataConsulta;
    private Date horaConsulta;
    private int animalId;
    private int funcionarioId;

    // Construtor
    public Consulta(int id, Date dataConsulta, Date horaConsulta, int animalId, int funcionarioId) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.animalId = animalId;
        this.funcionarioId = funcionarioId;
    }

    public Consulta() {
        //TODO Auto-generated constructor stub
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date novaHoraConsultaStr) {
        this.horaConsulta = novaHoraConsultaStr;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataConsulta=" + dataConsulta +
                ", horaConsulta=" + horaConsulta +
                ", animalId=" + animalId +
                ", funcionarioId=" + funcionarioId +
                '}';
    }
}
