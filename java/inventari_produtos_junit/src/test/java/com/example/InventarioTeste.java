package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class InventarioTeste {
    private Inventario inventario;
   

    @Before
    public void setup(){
        inventario = new Inventario();
    }

    @Test
    public void testCreate(){
        Produto produto = new Produto(1, "teste1", "testeF1", 99.99, 10);
        inventario.create(produto);
        assertEquals(1,  inventario.read().size());
    }

    @Test
    public void testDelete(){
        testCreate();
        inventario.delete(1);
        assertEquals(1,  inventario.read().size());
    }

    @Test
    public void testUpdate(){
        testCreate();
        inventario.update(1, 20, 89.99);
        List<Produto> list = inventario.read();
        
        Produto produtoUpdate = list.get(0);
        assertEquals(20, produtoUpdate.getQuantidade());
        assertEquals(89.99, produtoUpdate.getPreco(), 0);
    }
}
