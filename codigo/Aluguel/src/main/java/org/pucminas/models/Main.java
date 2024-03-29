package org.pucminas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pucminas.Relatorio;

public class Main {

    private static List<Cliente> clientesCadastrados = new ArrayList<>();
    private static List<Equipamento> equipamentosCadastrados = new ArrayList<>();
    private static Relatorio relatorio = new Relatorio();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

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
                    cadastrarEquipamento();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    cadastrarAluguel();
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
                        relatorio.listeAlugueisEFaturamentoTotalDoMesEAno(mes, ano);
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

    //Método para cadastrar um cliente.
    private static void cadastrarCliente() {
        System.out.println("Digite os dados do cliente: ");
        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.print("Digite o documento: ");
        String documento = scan.nextLine();
        Cliente cliente = new Cliente(nome, documento);
        clientesCadastrados.add(cliente);
        System.out.println("Cliente cadastrado com sucesso. \n");
    }

    //Método para cadastrar um equipamento.
    private static void cadastrarEquipamento() {
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
        System.out.print("Digite a quantidade disponivel do equipamento: ");
        int quantidade = scan.nextInt();
        Equipamento equipamento = new Equipamento(codigo, nome, descricao, valor, quantidade);
        equipamentosCadastrados.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso. \n");
    }
    //Método para cadastrar um aluguel.
    private static void cadastrarAluguel() {
        System.out.print("Digite o documento do cliente: ");
        String documentoCliente = scan.nextLine();
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scan.nextLine();
        System.out.print("Digite o código do equipamento: ");
        int codigoEquipamento = scan.nextInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite a data de início (YYYY-MM-DD): ");
        String dataInicio = scan.nextLine();
        System.out.print("Digite a data de fim (YYYY-MM-DD): ");
        String dataFim = scan.nextLine();
        //verifica existencia do cliente em questão
        Cliente cliente = new Cliente().verificaCliente(clientesCadastrados, nomeCliente, documentoCliente);
        //verifica existencia do produto em questão
        Equipamento equipamento = new Equipamento().verificaEquipamento(equipamentosCadastrados, codigoEquipamento);
    
        if (cliente != null && equipamento != null) {
            if(equipamento.verificaQuantidadeDisponivel(quantidade)){
                equipamento.alugar(quantidade);
                relatorio.addAluguel(new Aluguel(cliente, equipamento, dataInicio, dataFim));
                System.out.println("Aluguel cadastrado com sucesso.\n");
            } else {
                System.out.println("Não há equipamentos suficientes disponíveis para aluguel.\n");
            }
        } else {
            System.out.println("Cliente ou equipamento não encontrado. Verifique os dados e tente novamente. \n");
            }
    }   
    
}
