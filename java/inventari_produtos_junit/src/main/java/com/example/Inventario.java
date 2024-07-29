package com.example;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    //Atributo
    List<Produto> list;

    //constrtor
    public Inventario() {
       list = new ArrayList<>();

    }
    //métodos
    //create
    public void create(Produto produto){
        list.add(produto);
    }
    //delete
    public void delete(int id){
        list.removeIf(produto->produto.getId()==id);
    }

    //update
    public void update(int id,int quantidade, double preco){
        for (Produto produto : list) {
            if (produto.getId()==id) {
                produto.setQuantidade(quantidade);
                produto.setPreco(preco);
                break;
            }
        }
    }

    //read
    public List<Produto> read(){
        return new ArrayList<>(list);
    }

}
