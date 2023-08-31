package org.pucminas.models;

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
        int numDias = calcularDiferencaDias(dataInicio, dataFim) + 1;
        return numDias * valorDiario;
    }

    private int calcularDiferencaDias(String inicio, String fim) {
        // Implementação simplificada para calcular a diferença em dias entre as datas.
        // Você pode usar bibliotecas de manipulação de datas para uma abordagem mais precisa.
        // Nesta implementação, considerei que as datas são strings no formato "dd/mm/yyyy".
        // Convertendo para objetos Date, você pode usar a biblioteca java.util.Date ou java.time.LocalDate.
        return 0;
    }

    @Override
    public String toString() {
        return "Aluguel (Cliente: " + cliente.getNome() + ", Equipamento: " + equipamento.getDescricao() +
                ", Data Início: " + dataInicio + ", Data Fim: " + dataFim + ", Valor Diário: " + valorDiario + ")";
    }
}
