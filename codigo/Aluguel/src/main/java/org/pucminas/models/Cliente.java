package org.pucminas.models;

import java.util.List;

public class Cliente {
    private String nome;
    private String documento;
    public Cliente(){}
    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

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
    @Override
    public String toString() {
        return "Cliente (Nome: " + nome + ", Documento: " + documento + ")";
    }

    
}
