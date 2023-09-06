package org.pucminas;

import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import java.util.*;
import java.util.stream.Collectors;

public class Relatorio {
    private List<Aluguel> aluguelList = new ArrayList<>();

    public Relatorio() {
    }

    public Relatorio(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    public Aluguel addAluguel(Aluguel aluguel) {
        aluguelList.add(aluguel);
        return aluguel;
    }

    public List<Aluguel> getAlugueis() {
        return aluguelList;
    }

    public void setAluguelList(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    private List<Aluguel> getAlugueis(String documento) {
        List<Aluguel> alugueisDoCliente = new ArrayList<>();
        for (Aluguel aluguel : aluguelList) {
            if (aluguel.getCliente().getDocumento().equals(documento)) {
                alugueisDoCliente.add(aluguel);
            }
        }
        return alugueisDoCliente;
    }

    public void imprimirInformacoesClientes(String documentoCliente) {

        List<Aluguel> alugueisCliente = getAlugueis(documentoCliente);
        double valorTotalCliente = 0.0;

        if (alugueisCliente.isEmpty()) {
            System.out.println("Cliente não encontrado ou sem aluguéis registrados.");
        } else {
            System.out.println("Aluguéis do cliente: " + alugueisCliente.get(0).getCliente().getNome());
            for (Aluguel aluguelCliente : alugueisCliente) {
                System.out.println("\n" + aluguelCliente.toString() + "\n");
                valorTotalCliente += aluguelCliente.getValorTotalAluguel();
            }
            System.out.println("Valor total dos aluguéis registrados ao cliente: " + valorTotalCliente);
            System.out.println("\n");
        }
    }

    public void listeAlugueisDoMesEAno(int mes, int ano) {
        List<Aluguel> alugueisDoMes = this.getAlugueisDoMes(mes, ano);
        System.out.println("Abaixo estão os alugueis do mês " + mes + " de " + ano + ": \n");
        for (Aluguel aluguel : alugueisDoMes) {
            System.out.println(aluguel.toString());
        }
        System.out.println(
                "O faturamento total do mês " + mes + " de " + ano + " foi: " + this.getFaturamentoTotalMes(mes, ano)
                        + "\n");
    }

    public List<Aluguel> getAlugueisDoMes(int mes, int ano) {
        return aluguelList.stream()
                .filter(aluguel -> isAluguelNoMes(aluguel, mes, ano))
                .collect(Collectors.toList());
    }

    public double getFaturamentoTotalMes(int mes, int ano) {
        List<Aluguel> alugueisDoMes = this.getAlugueisDoMes(mes, ano);
        System.out.println("Abaixo esta o faturamento total do mês " + mes + " de " + ano + ": ");
        double total = 0;
        for (Aluguel aluguel : alugueisDoMes) {
            total += aluguel.getValorTotalAluguel();
        }
        return total;
    }

    private boolean isAluguelNoMes(Aluguel aluguel, int mes, int ano) {
        String[] dataInicioParts = aluguel.getDataInicio().split("-");
        String[] dataFimParts = aluguel.getDataFim().split("-");
        int inicioMes = Integer.parseInt(dataInicioParts[1]);
        int inicioAno = Integer.parseInt(dataInicioParts[0]);
        int fimMes = Integer.parseInt(dataFimParts[1]);
        int fimAno = Integer.parseInt(dataFimParts[0]);

        return (inicioAno == ano && inicioMes == mes) || (fimAno == ano && fimMes == mes);
    }
}