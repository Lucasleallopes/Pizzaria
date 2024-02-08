package com.mycompany.pizzaria;
import java.util.List;

import java.util.Scanner;
import java.util.ArrayList;

public class Pizzaria {
    private String cnpj;
    private String nome_fantasia;
    private String endereco;
    
    public String getCnpj() {
		return cnpj;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	static Cliente cliente;
    static Pagamento pagamento;
    static Pedido pedido;
    static Scanner scan;
    
	public static void main (String[] args) {
        scan = new Scanner(System.in);
        System.out.println("---BEM VINDO A PIZZARIA DO LUCÃO --- \n");
        System.out.println("Qual dos servicos deseja utilizar? \n[1] Delivery \n[2] A la carte \n[3] Balcao");
        String resp = scan.nextLine();
        switch(resp){
            
            case "1":
                delivery();
                total();
                break;
            case "2":
                lacarte();
                total();
                break;
            case "3":
                retirada();
                total();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        
    }
	
    public static void delivery(){
        scan = new Scanner(System.in);
        cliente = new Cliente();
        pedido = new Pedido();
        pedido.setTipo("Delivery");
        
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(scan.nextLine());
        
        System.out.println("Informe o endereco de entrega: ");
        cliente.setEndereco(scan.nextLine());
        
        System.out.println("Informe o telefone para contato: ");
        cliente.setTelefone(scan.nextLine()); 
        
    }
    
    public static void lacarte(){
       System.out.println("Não é necessário cadastrar");
       cliente = new Cliente();
       pedido = new Pedido();
       pedido.setTipo("Lacarte");
    }
    public static void retirada(){
        scan = new Scanner(System.in);
        cliente = new Cliente();
        pedido = new Pedido();
        pedido.setTipo("Retirada");
        
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(scan.nextLine());
        
        System.out.println("Informe o endereco de entrega: ");
        cliente.setTelefone(scan.nextLine());
        
        System.out.println("Informe o telefone para contato: ");
        cliente.setEndereco(scan.nextLine()); 

    }
        private static  List<Pizza> pizzasEscolhidas = new ArrayList<>();
        
        public static float escolhersabor() {
            boolean parada = true;
            String continuar = "";
            float valorTotal = 0;
            
            while (parada) {
                scan = new Scanner(System.in);
                System.out.println("Escolha o tipo da pizza:");
                System.out.println("1. Salgada");
                System.out.println("2. Doce");
                System.out.println("3. Mista");

                String tipoPizza = scan.nextLine();

                int counter;
                List<Pizza> pizzasMistas = Pizza.getPizzasMistas();
                List<Pizza> pizzasSalgadas = Pizza.getPizzasSalgadas();
                List<Pizza> pizzasDoces = Pizza.getPizzasDoces();

                switch (tipoPizza) {

                case "1":
                    counter = 1;

                    for (Pizza pizza : pizzasSalgadas) {
                        System.out.println(counter + ". " + pizza.getTipoSabor() + " - R$" + pizza.getValor());
                        counter++;
                    }
                    
                    boolean escolhaValida = false;
                    while (!escolhaValida) {
                        System.out.println("Escolha o Sabor pelo número:");
                        if (scan.hasNextInt()) {
                            int saborEscolhido = scan.nextInt();
                            scan.nextLine();

                            if (saborEscolhido >= 1 && saborEscolhido <= pizzasSalgadas.size()) {
                                Pizza pizzaEscolhida = pizzasSalgadas.get(saborEscolhido - 1);
                                pizzasEscolhidas.add(pizzaEscolhida);
                                valorTotal += pizzaEscolhida.getValor();
                                escolhaValida = true;
                            } else {
                                System.out.println("Opção inválida. Escolha um número válido.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            scan.nextLine(); // Limpar a entrada inválida para evitar loop infinito
                        }
                    }
                    break;


                case "2":
                    counter = 1;

                    for (Pizza pizza : pizzasDoces) {
                        System.out.println(counter + ". " + pizza.getTipoSabor() + " - R$" + pizza.getValor());
                        counter++;
                    }
                    
                    escolhaValida = false;
                    while (!escolhaValida) {
                        System.out.println("Escolha o Sabor pelo número:");
                        if (scan.hasNextInt()) {
                            int saborDoceEscolhido = scan.nextInt();
                            scan.nextLine();

                            if (saborDoceEscolhido >= 1 && saborDoceEscolhido <= pizzasDoces.size()) {
                                Pizza pizzaEscolhida = pizzasDoces.get(saborDoceEscolhido - 1);
                                pizzasEscolhidas.add(pizzaEscolhida);
                                valorTotal += pizzaEscolhida.getValor();
                                escolhaValida = true;
                            } else {
                                System.out.println("Opção inválida. Escolha um número válido.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            scan.nextLine(); // Limpar a entrada inválida para evitar loop infinito
                        }
                    }
                    break;
                    
                case "3":
                    System.out.println("Pizzas mistas:");
                    counter = 1;

                    for (Pizza pizza : pizzasMistas) {
                        System.out.println(counter + ". " + pizza.getTipoSabor() + " - R$" + pizza.getValor());
                        counter++;
                    }
                    
                    escolhaValida = false;
                    while (!escolhaValida) {
                        System.out.println("Escolha o Primeiro sabor pelo número:");
                        if (scan.hasNextInt()) {
                            int numMista1 = scan.nextInt();
                            scan.nextLine();

                            System.out.println("Escolha o Segundo sabor pelo número:");
                            if (scan.hasNextInt()) {
                                int numMista2 = scan.nextInt();
                                scan.nextLine();

                                if (numMista1 >= 1 && numMista1 <= pizzasMistas.size() && numMista2 >= 1 && numMista2 <= pizzasMistas.size()) {
                                    Pizza sabor1 = pizzasMistas.get(numMista1 - 1);
                                    Pizza sabor2 = pizzasMistas.get(numMista2 - 1);
                                    Pizza mista = new Pizza();
                                    mista.setValor((sabor1.getValor() + sabor2.getValor()) / 2);

                                    Pizza pizzaEscolhida = new Pizza(sabor1.getTipoSabor() + " + " + sabor2.getTipoSabor(), (sabor1.getValor() + sabor2.getValor()) / 2);
                                    pizzasEscolhidas.add(pizzaEscolhida);
                                    valorTotal += pizzaEscolhida.getValor();
                                    escolhaValida = true;
                                } else {
                                    System.out.println("Opção inválida. Escolha números válidos.");
                                }
                            } else {
                                System.out.println("Entrada inválida. Digite um número inteiro.");
                                scan.nextLine(); // Limpar a entrada inválida para evitar loop infinito
                            }
                        } else {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            scan.nextLine(); // Limpar a entrada inválida para evitar loop infinito
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida (1, 2 ou 3).");
                    continue; // Volta ao início do loop para nova escolha
                }

                System.out.println("Deseja adicionar mais uma pizza? \n [s/n] ");
                continuar = scan.nextLine();

                while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("Deseja adicionar mais uma pizza? \n [s/n] ");
                    continuar = scan.nextLine();
                }

                parada = continuar.equalsIgnoreCase("s");
            }

            System.out.println("");
            return valorTotal;
        }
        
        private static List<Bebidas> bebidasSelecionadas = new ArrayList<>();

        public static float escolherBebida() {
            List<Bebidas> bebidas = Bebidas.getBebidas();
            scan = new Scanner(System.in);
            boolean maisalgumacoisa = true;
            int counter;
            int bebidaescolhida;
            String escolha = "";
            float total = 0;

            while (maisalgumacoisa) {
                System.out.println("Bebidas? [s/n]");
                escolha = scan.nextLine();

                switch (escolha) {
                    case "s":
                        System.out.println("Escolha a bebida pelo número: \n");
                        counter = 1;

                        for (Bebidas b : bebidas) {
                            System.out.println(counter + ". " + b.getNome() + " - R$" + b.getPreco());
                            counter++;
                        }

                        boolean bebidaEscolhidaValida = false;
                        while (!bebidaEscolhidaValida) {
                            bebidaescolhida = scan.nextInt();
                            scan.nextLine();

                            if (bebidaescolhida >= 1 && bebidaescolhida <= bebidas.size()) {
                                Bebidas bebidaselecionada = bebidas.get(bebidaescolhida - 1);
                                bebidasSelecionadas.add(bebidaselecionada);
                                total += bebidaselecionada.getPreco();
                                bebidaEscolhidaValida = true;
                            } else {
                                System.out.println("Opção inválida. Escolha um número válido.");
                            }
                        }

                        break;

                    case "n":
                        maisalgumacoisa = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                System.out.println("");
            }

            return total;
        }
        public static void escolherPagamento() {
            scan = new Scanner(System.in);
            pagamento = new Pagamento();
            String escolha;
            boolean confirmar = true;

            while (confirmar) {
                System.out.println("Escolha a forma de pagamento:");
                System.out.println("[1] PIX");
                System.out.println("[2] Cartão de Débito");
                System.out.println("[3] Cartão de Crédito");
                escolha = scan.nextLine();

                switch (escolha) {
                    case "1":
                        pagamento.setFormaPagamento("PIX");
                        confirmar = false;
                        break;
                    case "2":
                        pagamento.setFormaPagamento("Cartão de Débito");
                        confirmar = false;
                        break;
                    case "3":
                        pagamento.setFormaPagamento("Cartão de Crédito");
                        confirmar = false;
                        break;
                    default:
                        System.out.println("Erro! Digite uma das opções apresentadas.");
                        break;
                }
            }
            
            System.out.println("===========================================================");
            System.out.println("                        RECIBO");

            Pizzaria pizzaria = new Pizzaria();
            pizzaria.setNome_fantasia("PIZZARIA DO LUCÃO");
            pizzaria.setEndereco("R. Tiradentes, 1139 - Centro, Cascavel - PR, 85812-200");
            pizzaria.setCnpj("29.769.113/0001-38");

            System.out.println(pizzaria.getNome_fantasia());
            System.out.println(pizzaria.getEndereco());
            System.out.println(pizzaria.getCnpj());
            System.out.println("");

            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
        }

        public static void total() {
            float totalPizzas = escolhersabor();
            float totalBebidas = escolherBebida();
            float total = totalBebidas + totalPizzas;
            escolherPagamento();
            System.out.println("");

            System.out.println("Quantidade de pizzas: " + pizzasEscolhidas.size());
            System.out.println("Quantidade de bebidas: " + bebidasSelecionadas.size());

            System.out.println("");
            System.out.println("Pizzas selecionadas:");
            for (Pizza pizza : pizzasEscolhidas) {
                System.out.println("- " + pizza.getTipoSabor() + " - R$" + pizza.getValor());
            }

            System.out.println("");
            System.out.println("Bebidas selecionadas:");
            for (Bebidas bebida : bebidasSelecionadas) {
                System.out.println("- " + bebida.getNome() + " - R$" + bebida.getPreco());
            }

            System.out.println("\nTipo do pedido: " + pedido.getTipo());
            System.out.println("Forma de pagamento: " + pagamento.getFormaPagamento());
            System.out.println("Total: R$" + total);
            System.out.println("=========================================================");
        }
}
