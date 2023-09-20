package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.Relatorio;
import org.pucminas.models.Aluguel;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

public class RelatorioTest {
    private Relatorio relatorio;
    private Aluguel aluguel1;
    private Aluguel aluguel2;

    @Before
    public void setUp() {
        relatorio = new Relatorio();
        Cliente joao = new Cliente("12345", "Joao");
        Cliente maria = new Cliente("67890", "Maria");
        aluguel1 = new Aluguel(joao, new Equipamento(1, "Enxada", "Aço inox", 100.0, 10), "2023-09-01", "2023-09-05");
        aluguel2 = new Aluguel(maria, new Equipamento(2, "Pa De Madeira", "Preta", 200.0, 5), "2023-09-02", "2023-09-07");
    }

    /**
     * Testa o método addAluguel.
     */
    @Test
    public void testAddAluguel() {
        // Adiciona um aluguel ao relatório
        relatorio.addAluguel(aluguel1);

        // Obtém a lista de aluguéis do relatório
        List<Aluguel> alugueis = relatorio.getAlugueis();

        // Verifica se o aluguel foi adicionado corretamente à lista
        assertEquals(1, alugueis.size());
        assertTrue(alugueis.contains(aluguel1));
    }

    /**
     * Testa o método getAlugueisDoMes.
     */
    @Test
    public void testGetAlugueisDoMes() {
        // Adiciona dois aluguéis ao relatório
        relatorio.addAluguel(aluguel1);
        relatorio.addAluguel(aluguel2);

        // Obtém a lista de aluguéis do mês de setembro de 2023
        List<Aluguel> alugueisDoMes = relatorio.getAlugueisDoMes(9, 2023);

        // Verifica se a lista contém os aluguéis adicionados
        assertEquals(2, alugueisDoMes.size());
        assertTrue(alugueisDoMes.contains(aluguel1));
        assertTrue(alugueisDoMes.contains(aluguel2));
    }

    /**
     * Testa o método getFaturamentoTotalMes.
     */
    @Test
    public void testGetFaturamentoTotalMes() {
        // Adiciona dois aluguéis ao relatório
        relatorio.addAluguel(aluguel1);
        relatorio.addAluguel(aluguel2);

        // Obtém o faturamento total do mês de setembro de 2023
        double faturamentoTotal = relatorio.getFaturamentoTotalMes(9, 2023);

        // Verifica se o faturamento total calculado está correto
        assertEquals(1400.0, faturamentoTotal, 0.0001);
    }
}
