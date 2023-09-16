package test;


import org.junit.Before;
import org.junit.Test;
import org.pucminas.Relatorio;
import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.List;

public class RelatorioTest {
    private Relatorio relatorio;
    private Aluguel aluguel1;
    private Aluguel aluguel2;

    @Before
    public void setUp() {
        relatorio = new Relatorio();
        Cliente joao= new Cliente("12345", "Joao");
        Cliente maria = new Cliente("67890", "Maria");
        aluguel1 = new Aluguel(joao,new Equipamento(1, "Enxada", "Aço inox", 100.0, 10), "2023-09-01", "2023-09-05");
        aluguel2 = new Aluguel( maria, new Equipamento(2, "Pa De Madeira", "Preta", 200.0, 5), "2023-09-02", "2023-09-07");
    }

    @Test
    public void testAddAluguel() {
        relatorio.addAluguel(aluguel1);
        List<Aluguel> alugueis = relatorio.getAlugueis();
        assertEquals(1, alugueis.size());
        assertTrue(alugueis.contains(aluguel1));
    }

    @Test
    public void testGetAlugueisDoMes() {
        relatorio.addAluguel(aluguel1);
        relatorio.addAluguel(aluguel2);

        List<Aluguel> alugueisDoMes = relatorio.getAlugueisDoMes(9, 2023);
        assertEquals(2, alugueisDoMes.size());
        assertTrue(alugueisDoMes.contains(aluguel1));
        assertTrue(alugueisDoMes.contains(aluguel2));
    }

    @Test
    public void testGetFaturamentoTotalMes() {
        relatorio.addAluguel(aluguel1); 
        relatorio.addAluguel(aluguel2); 

        double faturamentoTotal = relatorio.getFaturamentoTotalMes(9, 2023);
        assertEquals(1400.0, faturamentoTotal, 0.0001);
    }
}
