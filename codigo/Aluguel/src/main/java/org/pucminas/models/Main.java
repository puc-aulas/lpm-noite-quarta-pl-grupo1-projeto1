package org.pucminas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pucminas.Relatorio;

public class Main {

    private static List<Cliente> clientesCadastrados = new ArrayList<>();
    private static List<Equipamento> equipamentosCadastrados = new ArrayList<>();
    private static Relatorio relatorio = new Relatorio();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Equipamento");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Cadastrar Aluguel");
            System.out.println("4 - Imprimir informações de um cliente");
            System.out.println("5 - Listar alugueis do mês e ano");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEquipamento(scan);
                    break;
                case 2:
                    cadastrarCliente(scan);
                    break;
                case 3:
                    cadastrarAluguel(scan);
                    break;
                case 4:
                    System.out.print("Digite o documento do cliente: ");
                    String documento = scan.nextLine();
                    relatorio.imprimirInformacoesClientes(documento);
                    break;
                case 5:
                    System.out.print("Digite o mês e o ano (MM-YYYY): ");
                    String data = scan.nextLine();
                    String[] partes = data.split("-");
                    if (partes.length == 2) {
                        int mes = Integer.parseInt(partes[0]);
                        int ano = Integer.parseInt(partes[1]);
                        relatorio.listeAlugueisDoMesEAno(mes, ano);
                    } else {
                        System.out.println("Formato de data inválido.");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa. \n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente. \n");
            }
        } while (opcao != 6);
    }

    private static void cadastrarCliente(Scanner scan) {
        System.out.println("Digite os dados do cliente: ");
        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.print("Digite o documento: ");
        String documento = scan.nextLine();
        Cliente cliente = new Cliente(nome, documento);
        clientesCadastrados.add(cliente);
        System.out.println("Cliente cadastrado com sucesso. \n");
    }

    private static void cadastrarEquipamento(Scanner scan) {
        System.out.println("Digite os dados do Equipamento: ");
        System.out.print("Digite o código: ");
        int codigo = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.print("Digite a descrição: ");
        String descricao = scan.nextLine();
        System.out.print("Digite o valor por dia: ");
        double valor = scan.nextDouble();
        Equipamento equipamento = new Equipamento(codigo, nome, descricao, valor);
        equipamentosCadastrados.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso. \n");
    }

    private static void cadastrarAluguel(Scanner scan) {
        System.out.print("Digite o documento do cliente: ");
        String documentoCliente = scan.nextLine();
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scan.nextLine();
        System.out.print("Digite o código do equipamento: ");
        int codigoEquipamento = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite a data de início (YYYY-MM-DD): ");
        String dataInicio = scan.nextLine();
        System.out.print("Digite a data de fim (YYYY-MM-DD): ");
        String dataFim = scan.nextLine();

        Cliente cliente = null;
        for (Cliente c : clientesCadastrados) {
            if (c.getDocumento().equals(documentoCliente) && c.getNome().equals(nomeCliente)) {
                cliente = c;
                break;
            }
        }

        Equipamento equipamento = null;
        for (Equipamento e : equipamentosCadastrados) {
            if (e.getCodigo() == codigoEquipamento) {
                equipamento = e;
                break;
            }
        }

        if (cliente != null && equipamento != null) {
            relatorio.addAluguel(new Aluguel(cliente, equipamento, dataInicio, dataFim));
            System.out.println("Aluguel cadastrado com sucesso.\n");
        } else {
            System.out.println("Cliente ou equipamento não encontrado. Verifique os dados e tente novamente. \n");
        }
    }
}
