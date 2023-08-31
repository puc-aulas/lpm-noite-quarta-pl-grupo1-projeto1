package org.pucminas.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private String dataInicio;
    private String dataFim;
    private double valorDiario;

    public Aluguel(Cliente cliente, Equipamento equipamento, String dataInicio, String dataFim, double valorDiario) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public double getValorTotalAluguel() {
        long numDias = calcularDiferencaDias(dataInicio, dataFim);
        return numDias * valorDiario;
    }

    private long calcularDiferencaDias(String dataInicioStr, String dataFimStr) {
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);
        LocalDate dataFim = LocalDate.parse(dataFimStr);

        long diferencaDias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        return diferencaDias;
    }

    @Override
    public String toString() {
        return "Aluguel (Cliente: " + cliente.getNome() + ", Equipamento: " + equipamento.getDescricao() +
                ", Data Início: " + dataInicio + ", Data Fim: " + dataFim + ", Valor Diário: " + valorDiario + ")";
    }
}
