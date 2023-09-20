package org.pucminas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.pucminas.models.Aluguel;

public class Relatorio {
    private List<Aluguel> aluguelList = new ArrayList<>();

    public Relatorio() {
    }

    public Relatorio(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    /**
     * Adiciona um aluguel à lista de aluguéis.
     *
     * @param aluguel O aluguel a ser adicionado.
     * @return O aluguel adicionado.
     */
    public Aluguel addAluguel(Aluguel aluguel) {
        aluguelList.add(aluguel);
        return aluguel;
    }

    /**
     * Obtém a lista de todos os aluguéis.
     *
     * @return A lista de aluguéis.
     */
    public List<Aluguel> getAlugueis() {
        return aluguelList;
    }

    /**
     * Define a lista de aluguéis.
     *
     * @param aluguelList A lista de aluguéis a ser definida.
     */
    public void setAluguelList(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    /**
     * Obtém os aluguéis de um cliente com base no documento do cliente.
     *
     * @param documento O documento do cliente.
     * @return Uma lista de aluguéis do cliente.
     */
    private List<Aluguel> getAlugueis(String documento) {
        List<Aluguel> alugueisDoCliente = new ArrayList<>();
        for (Aluguel aluguel : aluguelList) {
            if (aluguel.getCliente().getDocumento().equals(documento)) {
                alugueisDoCliente.add(aluguel);
            }
        }
        return alugueisDoCliente;
    }

    /**
     * Imprime as informações dos aluguéis de um cliente com base no documento do cliente.
     *
     * @param documentoCliente O documento do cliente.
     */
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

    /**
     * Lista os aluguéis e o faturamento total de um mês e ano específicos.
     *
     * @param mes  O mês desejado.
     * @param ano  O ano desejado.
     */
    public void listeAlugueisEFaturamentoTotalDoMesEAno(int mes, int ano) {
        List<Aluguel> alugueisDoMes = this.getAlugueisDoMes(mes, ano);
        System.out.println("Abaixo estão os aluguéis do mês " + mes + " de " + ano + ": \n");
        for (Aluguel aluguel : alugueisDoMes) {
            System.out.println(aluguel.toString());
        }
        System.out.println(
                "O faturamento total do mês " + mes + " de " + ano + " foi: " + this.getFaturamentoTotalMes(mes, ano)
                        + "\n");
    }

    /**
     * Obtém uma lista de aluguéis para um mês e ano específicos.
     *
     * @param mes O mês desejado.
     * @param ano O ano desejado.
     * @return Uma lista de aluguéis do mês e ano especificados.
     */
    public List<Aluguel> getAlugueisDoMes(int mes, int ano) {
        return aluguelList.stream()
                .filter(aluguel -> isAluguelNoMes(aluguel, mes, ano))
                .collect(Collectors.toList());
    }

    /**
     * Calcula e obtém o faturamento total de um mês e ano específicos.
     *
     * @param mes O mês desejado.
     * @param ano O ano desejado.
     * @return O faturamento total do mês e ano especificados.
     */
    public double getFaturamentoTotalMes(int mes, int ano) {
        List<Aluguel> alugueisDoMes = this.getAlugueisDoMes(mes, ano);
        System.out.println("Abaixo está o faturamento total do mês " + mes + " de " + ano + ": ");
        double total = 0;
        for (Aluguel aluguel : alugueisDoMes) {
            total += aluguel.getValorTotalAluguel();
        }
        System.out.println(total);
        return total;
    }

    /**
     * Verifica se um aluguel ocorre em um mês e ano específicos.
     *
     * @param aluguel O aluguel a ser verificado.
     * @param mes     O mês desejado.
     * @param ano     O ano desejado.
     * @return true se o aluguel ocorrer no mês e ano especificados, caso contrário, false.
     */
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
