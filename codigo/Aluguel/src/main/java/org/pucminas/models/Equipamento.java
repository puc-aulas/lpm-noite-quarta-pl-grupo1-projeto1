package org.pucminas.models;

public class Equipamento {
    private int codigo;
    private String descricao;
    private String nome;
    private double valorDiario;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private boolean disponivel;

    public Equipamento() {
    }


    public Equipamento(int codigo, String nome, String descricao, double valorDiario, int quantidadeTotal) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.valorDiario = valorDiario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void alugar(int quantidade) {
        if (quantidade <= quantidadeDisponivel) {
            quantidadeDisponivel -= quantidade;
        } else {
            System.out.println("Não há equipamentos suficientes disponíveis.");
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Equipamento (Código: " + codigo + ", Descrição: " + descricao + ")";
    }
}
