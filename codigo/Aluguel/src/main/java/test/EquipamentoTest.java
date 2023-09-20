package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.models.Equipamento;

public class EquipamentoTest {
    private Equipamento equipamento;

    @Before
    public void setUp() {
        equipamento = new Equipamento(1, "Enxada", "Cabo reforçado", 100.0, 2);
    }
    /**
     * Testa o método de alugar equipamento.
     */
    @Test
    public void testAlugar() {
        // Tenta alugar 5 unidades do equipamento
        equipamento.alugar(5);
        // Verifica se a quantidade disponível foi reduzida para 5
        assertEquals(5, equipamento.getQuantidadeDisponivel());
        // Tenta alugar mais 10 unidades do equipamento, o que não deve ser possível
        equipamento.alugar(10);
        // Verifica se a quantidade disponível ainda é 5, não foi possível alugar mais
        assertEquals(5, equipamento.getQuantidadeDisponivel());
    }
    /**
     * Testa o método setDisponivel.
     */
    @Test
    public void testSetDisponivel() {

        // Define o equipamento como não disponível
        equipamento.setDisponivel(false);
        // Verifica se o equipamento está marcado como não disponível
        assertFalse(equipamento.isDisponivel());
    }
    /**
     * Testa o método toString.
     */
    @Test
    public void testToString() {
        // Cria uma representação esperada do equipamento em forma de String
        String expected = "Equipamento (Código: 1, Descrição: Cabo reforçado)";
        // Verifica se a representação gerada pelo método toString coincide com a esperada
        assertEquals(expected, equipamento.toString());
    }
    /**
     * Testa o método verificaQuantidadeDisponivel quando há quantidade disponível.
     */
    @Test
    public void testVerificaQuantidadeDisponivel() {
        // Verifica se há quantidade disponível de 2 unidades
        boolean existeEquipamentos = equipamento.verificaQuantidadeDisponivel(2);

        // Deve retornar verdadeiro, pois há quantidade disponível
        assertTrue(existeEquipamentos);
    }

    /**
     * Testa o método verificaQuantidadeDisponivel quando não há quantidade disponível.
     */
    @Test
    public void testVerificaQuantidadeNaoDisponivel() {
        // Verifica se há quantidade disponível de 8 unidades, o que não deve ser possível
        boolean existeEquipamentos = equipamento.verificaQuantidadeDisponivel(8);

        // Deve retornar falso, pois não há quantidade disponível suficiente
        assertFalse(existeEquipamentos);
    }

    /**
     * Testa o método verificaEquipamento quando o equipamento existe na lista de equipamentos.
     */
    @Test
    public void testVerificaEquipamento() {
        // Cria uma lista de equipamentos e adiciona o equipamento de teste
        List<Equipamento> equipamentos = new ArrayList<>();
        equipamentos.add(equipamento);

        // Chama o método verificaEquipamento para verificar a existência do equipamento
        Equipamento existeEquipamento = equipamento.verificaEquipamento(equipamentos, 1);

        // Compara o resultado com o equipamento de teste
        assertEquals(existeEquipamento, equipamento);
    }

    /**
     * Testa o método verificaEquipamento quando o equipamento não existe na lista de equipamentos.
     */
    @Test
    public void testVerificaEquipamentoNaoExistente() {
        // Cria uma lista de equipamentos vazia
        List<Equipamento> equipamentos = new ArrayList<>();

        // Chama o método verificaEquipamento para verificar a existência do equipamento
        Equipamento equipamentoNull = null; // Espera-se que não exista o equipamento
        Equipamento existeEquipamento = equipamento.verificaEquipamento(equipamentos, 1);

        // Compara o resultado com null, indicando que o equipamento não foi encontrado
        assertEquals(existeEquipamento, equipamentoNull);
    }
}
