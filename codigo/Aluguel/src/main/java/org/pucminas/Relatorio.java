package org.pucminas;

import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import java.util.*;

public class Relatorio {
    private List<Aluguel> aluguelList = new ArrayList<>();
    public Relatorio() {
    }

    public Relatorio(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }
    public Aluguel addAluguel(Aluguel aluguel){
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
    private void imprimirInformaçõesClientes() {
        Map<String, List<Aluguel>> alugueisPorCliente = new HashMap<>();

        for (Aluguel aluguel : aluguelList) {
            String documentoCliente = aluguel.getCliente().getDocumento();
            if (!alugueisPorCliente.containsKey(documentoCliente)) {
                alugueisPorCliente.put(documentoCliente, getAlugueis(documentoCliente));
            }
        }

        for (Map.Entry<String, List<Aluguel>> entry : alugueisPorCliente.entrySet()) {
            String documentoCliente = entry.getKey();
            List<Aluguel> alugueisCliente = entry.getValue();
            double valorTotalCliente = 0.0;

            System.out.println("Aluguéis do cliente: " + alugueisCliente.get(0).getCliente().getNome());
            for (Aluguel aluguelCliente : alugueisCliente) {
                System.out.println("\n"+aluguelCliente.toString() + " \nValor total do aluguel "+ aluguelCliente.getValorTotalAluguel());
                valorTotalCliente += aluguelCliente.getValorTotalAluguel();
            }
            System.out.println("\n\nValor total dos aluguéis registrado ao cliente: " + valorTotalCliente);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();

        Cliente cliente1 = new Cliente("João", "123456789");
        Cliente cliente2 = new Cliente("Maria", "987654321");

        Equipamento equipamento1 = new Equipamento(1, "Escavadeira",1000.0);
        Equipamento equipamento2 = new Equipamento(2, "Betoneira",200.2);
        Equipamento equipamento3 = new Equipamento(2, "Caminhão",2006.0);

        relatorio.addAluguel(new Aluguel(cliente1, equipamento1, "2023-08-01", "2023-08-10"));
        relatorio.addAluguel(new Aluguel(cliente2, equipamento2, "2023-08-05", "2023-08-15"));
        relatorio.addAluguel(new Aluguel(cliente2, equipamento3, "2023-08-09", "2023-08-15"));
        relatorio.addAluguel(new Aluguel(cliente2, equipamento3, "2023-08-15", "2023-08-18"));
        relatorio.addAluguel(new Aluguel(cliente1, equipamento2, "2023-08-09", "2023-08-15"));

        relatorio.imprimirInformaçõesClientes();
    }
}