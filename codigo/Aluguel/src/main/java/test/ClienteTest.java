package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pucminas.models.Cliente;
import org.pucminas.models.Equipamento;
public class ClienteTest {
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente("João", "02112345612");
    }
    /**
     * Testa o método verificaCliente quando o cliente existe na lista de clientes.
     */
    @Test
    public void testVerificaCliente(){
        // Cria uma lista de clientes e adiciona o cliente de teste
        List<Cliente> equipamentos = new ArrayList<>();
        equipamentos.add(cliente);
        // Chama o método verificaCliente para verificar a existência do cliente
        Cliente existeEquipamento = cliente.verificaCliente(equipamentos, "João", "02112345612");
        // Compara o resultado com o cliente de teste
        assertEquals(existeEquipamento, cliente);
    }
    /**
     * Testa o método verificaCliente quando o cliente não existe na lista de clientes.
     */
    @Test
    public void testVerificaClienteNaoExiste(){
        // Cria uma lista de clientes vazia
        List<Cliente> equipamentos = new ArrayList<>();
        Equipamento equipamentoNull = null;
        // Chama o método verificaCliente para verificar a existência do cliente
        Cliente existeEquipamento = cliente.verificaCliente(equipamentos, "João", "02112345612");
        // Compara o resultado com null, indicando que o cliente não foi encontrado
        assertEquals(existeEquipamento, equipamentoNull);
    }
}
