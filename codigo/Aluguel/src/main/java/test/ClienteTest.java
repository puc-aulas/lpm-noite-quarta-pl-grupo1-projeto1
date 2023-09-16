package test;

import org.junit.Test;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
public class ClienteTest {
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente("João", "02112345612");
    }
    @Test
    public void testVerificaCliente(){
        List<Cliente> equipamentos = new ArrayList<>();
        equipamentos.add(cliente);
        Cliente existeEquipamento = cliente.verificaCliente(equipamentos, "João", "02112345612");
        assertEquals(existeEquipamento, cliente);
    }
    @Test
    public void testVerificaClienteNaoExiste(){
        List<Cliente> equipamentos = new ArrayList<>();
        Equipamento equipamentoNull = null;
        Cliente existeEquipamento = cliente.verificaCliente(equipamentos, "João", "02112345612");
        assertEquals(existeEquipamento, equipamentoNull);
    }
}
