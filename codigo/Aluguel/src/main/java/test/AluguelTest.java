package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

public class AluguelTest {

    /**
     * Testa o cálculo do valor total de um aluguel.
     */
    @Test
    public void testCalcularValorTotalAluguel() {
        // Cria um cliente e um equipamento para o teste
	     Cliente cliente = new Cliente("12345", "Carlos");
	     Equipamento equipamento = new Equipamento(1, "Furadeira", "Phillips Bivolt", 100.0, 10);
         // Cria um aluguel com datas de início e término
    	 Aluguel aluguel = new Aluguel(cliente, equipamento, "2023-09-01", "2023-09-05");
         // Calcula o valor total do aluguel
        aluguel.calcularValorTotalAluguel();
        // Compara o valor calculado com o valor esperado (400.0)
        assertEquals(400.0, aluguel.getValorTotalAluguel(), 0.00001);
    }
    /**
     * Testa o cálculo da diferença em dias entre duas datas.
     */
    @Test
    public void testCalcularDiferencaDias(){
        long result = 4;
        // Data de início e data de término
        Aluguel aluguel = new Aluguel();
        // Calcula a diferença em dias entre as datas
        long diferenca = aluguel.calcularDiferencaDias("2023-09-16", "2023-09-20");
        // Compara a diferença calculada com o resultado esperado (4)
        assertEquals(result, diferenca);
    }
}
