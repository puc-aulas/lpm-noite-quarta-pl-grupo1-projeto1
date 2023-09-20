package org.pucminas.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private String dataInicio;
    private String dataFim;
    private double valorTotalAluguel;

    // Construtor da classe Aluguel
    public Aluguel(Cliente cliente, Equipamento equipamento, String dataInicio, String dataFim) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        calcularValorTotalAluguel();
    }
    // Construtor vazio
    public Aluguel(){

    }
    // Métodos getters e setters para os atributos da classe
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
    /*
     * Calcula o valor total do aluguel com base nas datas de início e término.
     */
    public void calcularValorTotalAluguel() {
        long numDias = calcularDiferencaDias(dataInicio, dataFim);
        valorTotalAluguel = numDias * this.getValorAluguelPorDia();
    }
    /**
     * Obtém o valor total do aluguel.
     * @return O valor total do aluguel.
     */
    public double getValorTotalAluguel() {
        return valorTotalAluguel;
    }
    /**
     * Define o valor total do aluguel.
     * @param valorTotalAluguel O valor total do aluguel.
     */
    public void setValorTotalAluguel(double valorTotalAluguel) {
        this.valorTotalAluguel = valorTotalAluguel;
    }
    /**
     * Obtém a quantidade de dias de aluguel.
     * @return A quantidade de dias de aluguel.
     */
    private long getDiasDeAluguel() {
        return calcularDiferencaDias(dataInicio, dataFim);
    }
    /**
     * Calcula a diferença em dias entre duas datas.
     * @param dataInicioStr A data de início (no formato 'YYYY-MM-DD').
     * @param dataFimStr    A data de término (no formato 'YYYY-MM-DD').
     * @return O número de dias de diferença entre as datas.
     */
    public long calcularDiferencaDias(String dataInicioStr, String dataFimStr) {
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);
        LocalDate dataFim = LocalDate.parse(dataFimStr);
        return ChronoUnit.DAYS.between(dataInicio, dataFim);
    }
    /**
     * Obtém o valor do aluguel por dia do equipamento.
     * @return O valor do aluguel por dia.
     */
    private double getValorAluguelPorDia() {
        return this.getEquipamento().getValorDiario();
    }
    /**
     * Sobrescreve o método toString para exibir informações do aluguel.
     * @return Uma representação em string do aluguel.
     */
    @Override
    public String toString() {
        return "cliente :" + cliente.getNome() +
                ", \nequipamento:" + equipamento.getNome() +
                ", \ndataInicio:'" + dataInicio + '\'' +
                ", \ndataFim:'" + dataFim + '\'' +
                ", \nduração:" + getDiasDeAluguel() + " dias " +
                ", \nvalor aluguel por dia: " + getValorAluguelPorDia() +
                ", \nvalor total do aluguel: " + getValorTotalAluguel() + "\n";
    }
}
