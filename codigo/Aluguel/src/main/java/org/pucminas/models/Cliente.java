package org.pucminas.models;

import java.util.List;

public class Cliente {
    private String nome;
    private String documento;

    // Construtor vazio
    public Cliente(){

    }
    // Construtor com parâmetros
    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }
    // Métodos getters e setters para os atributos da classe
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    /**
     * Verifica se um cliente está cadastrado na lista de clientes cadastrados.
     * @param clientesCadastrados A lista de clientes cadastrados.
     * @param nomeCliente         O nome do cliente a ser verificado.
     * @param documentoCliente    O documento do cliente a ser verificado.
     * @return O cliente encontrado na lista, ou null se não encontrado.
     */
    public Cliente verificaCliente(List<Cliente> clientesCadastrados, String nomeCliente, String documentoCliente ){
        Cliente cliente = null;
        for (Cliente c : clientesCadastrados) {
            if (c.getDocumento().equals(documentoCliente) && c.getNome().equals(nomeCliente)) {
                cliente = c;
                return cliente;
            }
        }
        return cliente;
    }
    /**
     * Sobrescreve o método toString para exibir informações do cliente.
     * @return Uma representação em string do cliente.
     */
    @Override
    public String toString() {
        return "Cliente (Nome: " + nome + ", Documento: " + documento + ")";
    }

    
}
