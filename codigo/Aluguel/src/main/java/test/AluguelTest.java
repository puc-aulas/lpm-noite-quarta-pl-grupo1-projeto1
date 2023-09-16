package test;

import org.junit.Test;
import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import static org.junit.Assert.assertEquals;

public class AluguelTest {

    @Test
    public void testCalcularValorTotalAluguel() {
	     Cliente cliente = new Cliente("12345", "Carlos");
	     Equipamento equipamento = new Equipamento(1, "Furadeira", "Phillips Bivolt", 100.0, 10);
    	 Aluguel aluguel = new Aluguel(cliente, equipamento, "2023-09-01", "2023-09-05");
        aluguel.calcularValorTotalAluguel();
        assertEquals(400.0, aluguel.getValorTotalAluguel(), 0.00001);
    }
    @Test
    public void testCalcularDiferencaDias(){
        long result = 4;
        Aluguel aluguel = new Aluguel();
        long diferenca = aluguel.calcularDiferencaDias("2023-09-16", "2023-09-20");
        assertEquals(result, diferenca);
    }
}
