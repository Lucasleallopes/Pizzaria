package com.mycompany.pizzaria;
import java.util.ArrayList;
import java.util.List;

public class Bebidas {
    private String nome;
    private float preco;
    
    public Bebidas(String nome, float preco) {
        this.nome = nome;
        this.preco = (float) preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }
    
    public static List<Bebidas> getBebidas() {
        List<Bebidas> bebidas = new ArrayList<>();
        bebidas.add(new Bebidas("Agua", (float) 4.0));
        bebidas.add(new Bebidas("Coca-Cola", (float) 8.0));
        bebidas.add(new Bebidas("Suco de laranja", (float) 6.0));
        bebidas.add(new Bebidas("Cerveja", (float) 5.5));
        bebidas.add(new Bebidas("Whisk", (float) 25.0));
        return bebidas;
        }
    }
