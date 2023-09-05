package org.pucminas.models;

public class Equipamento {
    private int codigo;
    private String descricao;
    private String nome;
    private double valorDiario;

    public Equipamento() {
    }


    public Equipamento(int codigo, String nome, String descricao, double valorDiario) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    @Override
    public String toString() {
        return "Equipamento (Código: " + codigo + ", Descrição: " + descricao + ")";
    }
}
