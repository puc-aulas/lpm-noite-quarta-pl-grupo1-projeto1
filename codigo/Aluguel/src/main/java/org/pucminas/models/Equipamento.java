package org.pucminas.models;

import java.util.List;

public class Equipamento {
    private int codigo;
    private String descricao;
    private String nome;
    private double valorDiario;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private boolean disponivel;

    // Construtor vazio
    public Equipamento() {
    }

    // Construtor com parâmetros
    public Equipamento(int codigo, String nome, String descricao, double valorDiario, int quantidadeTotal) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.valorDiario = valorDiario;
    }
    // Métodos getters e setters para os atributos da classe
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
    /**
     * Verifica se a quantidade de equipamentos disponíveis é suficiente para um aluguel.
     * @param quantidade: A quantidade desejada para aluguel.
     * @return true se a quantidade estiver disponível, false caso contrário.
     */

    public boolean verificaQuantidadeDisponivel(int quantidade){
        if(quantidadeDisponivel>= quantidade)
            return true;
        return false;
    }
    /**
     * Realiza o aluguel de equipamentos, atualizando a quantidade disponível.
     * @param quantidade A quantidade a ser alugada.
     */
    public void alugar(int quantidade) {
        if (quantidade <= quantidadeDisponivel) {
            quantidadeDisponivel -= quantidade;
        } else {
            System.out.println("Não há equipamentos suficientes disponíveis.");
        }
    }

    /**
     * Verifica se um equipamento está cadastrado na lista de equipamentos cadastrados.
     * @param equipamentosCadastrados A lista de equipamentos cadastrados.
     * @param codigoEquipamento       O código do equipamento a ser verificado.
     * @return O equipamento encontrado na lista, ou null se não encontrado.
     */
    public Equipamento verificaEquipamento(List<Equipamento> equipamentosCadastrados, int codigoEquipamento ){
        Equipamento equipamento = null;
        for (Equipamento e : equipamentosCadastrados) {
            if (e.getCodigo() == codigoEquipamento) {
                equipamento = e;
                return equipamento;
            }
        }
        return equipamento;
    }

    /**
     * Verifica se o equipamento está disponível para aluguel.
     * @return true se o equipamento estiver disponível, false caso contrário.
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Define a disponibilidade do equipamento para aluguel.
     * @param disponivel true se o equipamento estiver disponível, false caso contrário.
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Sobrescreve o método toString para exibir informações do equipamento.
     * @return Uma representação em string do equipamento.
     */
    @Override
    public String toString() {
        return "Equipamento (Código: " + codigo + ", Descrição: " + descricao + ")";
    }
}
