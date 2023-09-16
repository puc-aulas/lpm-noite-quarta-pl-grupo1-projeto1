package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testAlugar() {
        equipamento.alugar(5);
        assertEquals(5, equipamento.getQuantidadeDisponivel());

        equipamento.alugar(10);
        assertEquals(5, equipamento.getQuantidadeDisponivel());
    }

    @Test
    public void testSetDisponivel() {


        equipamento.setDisponivel(false);
        assertFalse(equipamento.isDisponivel());
    }

    @Test
    public void testToString() {
        String expected = "Equipamento (Código: 1, Descrição: Cabo reforçado)";
        assertEquals(expected, equipamento.toString());
    }

    @Test
    public void testVerificaQuantidadeDisponivel(){
        boolean existeEquipamentos = equipamento.verificaQuantidadeDisponivel(2);
        assertTrue(existeEquipamentos);
    }
    @Test
    public void testVerificaQuantidadeNaoDisponivel(){
        boolean existeEquipamentos = equipamento.verificaQuantidadeDisponivel(8);
        assertFalse(existeEquipamentos);
    }
    @Test
    public void testVerificaEquipamento(){
        List<Equipamento> equipamentos = new ArrayList<>();
        equipamentos.add(equipamento);
        Equipamento existeEquipamento = equipamento.verificaEquipamento(equipamentos, 1);
        assertEquals(existeEquipamento, equipamento);
    }
    @Test
    public void testVerificaEquipamentoNaoExistente(){
        Equipamento equipamentoNull = null;
        List<Equipamento> equipamentos = new ArrayList<>();
        Equipamento existeEquipamento = equipamento.verificaEquipamento(equipamentos, 1);
        assertEquals(existeEquipamento, equipamentoNull);
    }
}
