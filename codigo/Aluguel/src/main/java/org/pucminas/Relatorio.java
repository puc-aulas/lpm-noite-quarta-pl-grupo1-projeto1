package org.pucminas;

import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    public static void main(String[] args) {
        List<Aluguel> aluguelList = new ArrayList<>();
        Cliente cliente1 = new Cliente("João", "123456789");
        Cliente cliente2 = new Cliente("Maria", "987654321");

        Equipamento equipamento1 = new Equipamento(1, "Escavadeira",1000.0);
        Equipamento equipamento2 = new Equipamento(2, "Betoneira",200.2);

        Aluguel aluguel1 = new Aluguel(cliente1, equipamento1, "2023-08-01", "2023-08-10", 150.0);
        Aluguel aluguel2 = new Aluguel(cliente2, equipamento2, "2023-08-05", "2023-08-15", 100.0);
        aluguelList.add(aluguel1);
        aluguelList.add(aluguel2);


        System.out.println(aluguel1.toString());
        System.out.println("Valor total do aluguel 1: " + aluguel1.getValorTotalAluguel());

        System.out.println(aluguel2.toString());
        System.out.println("Valor total do aluguel 2: " + aluguel2.getValorTotalAluguel());

        for (Aluguel aluguel : aluguelList) {
            System.out.println("Aluguéis do cliente : "+aluguel.getCliente().getNome()+" "
                    + aluguel.getCliente().getAlugueis(aluguel.getCliente().getDocumento(),aluguelList)+
                    " \n Equipamento do tipo: "+aluguel.getEquipamento().getDescricao()+" alugado pelo valor "+aluguel.getValorTotalAluguel());
        }
    }
}