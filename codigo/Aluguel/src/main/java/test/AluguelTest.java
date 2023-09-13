package test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

public class AluguelTest {

    @Test
    public void testCalcularValorTotalAluguel() {
	     Cliente cliente = new Cliente("12345", "Carlos");
	     Equipamento equipamento = new Equipamento(1, "Furadeira", "Phillips Bivolt", 100.0, 10);
    	 Aluguel aluguel = new Aluguel(cliente, equipamento, "2023-09-01", "2023-09-05");
        aluguel.calcularValorTotalAluguel();
        assertEquals(400.0, aluguel.getValorTotalAluguel(), 0.00001);
    }
}
