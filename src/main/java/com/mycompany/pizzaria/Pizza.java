package com.mycompany.pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
 
    private String tipoSabor;
    private double valor;

    public Pizza(String tipoSabor, double valor) {
        this.tipoSabor = tipoSabor;
        this.valor = valor;
    }

    Pizza() {
    	this("Sem sabor", 0.0);
    }

    public void setTipoSabor(String tipoSabor){
        this.tipoSabor = tipoSabor;
    }
    
    public String getTipoSabor(){
        return this.tipoSabor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public static List<Pizza> getPizzasSalgadas() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Calabresa", (float) 30.0));
        pizzas.add(new Pizza("Portuguesa", (float) 35.0));
        pizzas.add(new Pizza("Mussarela", (float) 25.0));
        pizzas.add(new Pizza("Quatro queijos", (float) 20.0));
        pizzas.add(new Pizza("Frango com catupiry", (float) 35.0));
        pizzas.add(new Pizza("Stangonoff", (float) 33.0));
        pizzas.add(new Pizza("Bacon", (float) 35.0));
        pizzas.add(new Pizza("Palmito", (float) 40.0));
        pizzas.add(new Pizza("Cebola", (float) 32.0));
        pizzas.add(new Pizza("Escarola", (float) 35.0));
        return pizzas;
    }

    public static List<Pizza> getPizzasDoces() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Chocolate", (float) 25.0));
        pizzas.add(new Pizza("Brigadeiro", (float) 30.0));
        pizzas.add(new Pizza("Romeu e Julieta", (float) 35.0));
        pizzas.add(new Pizza("Banana com canela", (float) 30.0));
        pizzas.add(new Pizza("Prestígio", 35.0));
        pizzas.add(new Pizza("Morango com chocolate", (float) 40.0));
        pizzas.add(new Pizza("Abacaxi", (float) 30.0));
        pizzas.add(new Pizza("Sorvete", (float)35.0));
        pizzas.add(new Pizza("Doce de leite", (float) 30.0));
        pizzas.add(new Pizza("Rapadura", (float) 35.0));
        return pizzas;
    }
    
    public static List<Pizza> getPizzasMistas(){
        List<Pizza> pizzasMistas = new ArrayList<>();
        
        pizzasMistas.add(new Pizza("Calabresa", (float) 30.0));
        pizzasMistas.add(new Pizza("Portuguesa", (float) 35.0));
        pizzasMistas.add(new Pizza("Mussarela", (float) 25.0));
        pizzasMistas.add(new Pizza("Quatro queijos", (float) 20.0));
        pizzasMistas.add(new Pizza("Frango com catupiry", (float) 35.0));
        pizzasMistas.add(new Pizza("Stangonoff", (float) 33.0));
        pizzasMistas.add(new Pizza("Bacon", (float) 35.0));
        pizzasMistas.add(new Pizza("Palmito", (float) 40.0));
        pizzasMistas.add(new Pizza("Cebola", (float) 32.0));
        pizzasMistas.add(new Pizza("Escarola", (float) 35.0));
        pizzasMistas.add(new Pizza("Chocolate", (float) 25.0));
        pizzasMistas.add(new Pizza("Brigadeiro", (float) 30.0));
        pizzasMistas.add(new Pizza("Romeu e Julieta", (float) 35.0));
        pizzasMistas.add(new Pizza("Banana com canela", (float) 30.0));
        pizzasMistas.add(new Pizza("Prestígio", 35.0));
        pizzasMistas.add(new Pizza("Morango com chocolate", (float) 40.0));
        pizzasMistas.add(new Pizza("Abacaxi", (float) 30.0));
        pizzasMistas.add(new Pizza("Sorvete", (float)35.0));
        pizzasMistas.add(new Pizza("Doce de leite", (float) 30.0));
        pizzasMistas.add(new Pizza("Rapadura", (float) 35.0));
        
        return pizzasMistas;
    }
}
