package dev.omatheusmesmo;

import dev.omatheusmesmo.domain.Item;
import dev.omatheusmesmo.domain.Order;
import dev.omatheusmesmo.processing.OrderProcessor;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando a aplicação de Processamento de Pedidos ---");

        OrderProcessor processor = new OrderProcessor();

        System.out.println("\n===== TESTE: PEDIDO VÁLIDO E PAGO (FRETE GRÁTIS) =====");
        Order order1 = new Order("ORD-001", "Rua A, 123"); // Novo construtor
        order1.addItem(new Item("Laptop", 1, new BigDecimal("1200.00")));
        order1.addItem(new Item("Mouse", 2, new BigDecimal("50.00")));
        processor.process(order1);
        System.out.println("Pedido 1 Finalizado: " + order1.toString());

        System.out.println("\n===== TESTE: PEDIDO VÁLIDO (FRETE COBRADO) =====");
        Order order2 = new Order("ORD-002", "Av. B, 456");
        order2.addItem(new Item("Caneta", 5, new BigDecimal("5.00")));
        order2.addItem(new Item("Caderno", 3, new BigDecimal("15.00")));
        processor.process(order2);
        System.out.println("Pedido 2 Finalizado: " + order2.toString());

        System.out.println("\n===== TESTE: PEDIDO INVÁLIDO (VALOR ZERO) =====");
        Order order3 = new Order("ORD-003", "Rua C, 789");
        order3.addItem(new Item("Item Teste", 1, BigDecimal.ZERO)); // Valor zero
        processor.process(order3);
        System.out.println("Pedido 3 Finalizado: " + order3.toString());

        System.out.println("\n===== TESTE: PEDIDO INVÁLIDO (ENDEREÇO VAZIO) =====");
        Order order4 = new Order("ORD-004", ""); // Endereço vazio
        order4.addItem(new Item("Livro", 1, new BigDecimal("70.00")));
        processor.process(order4);
        System.out.println("Pedido 4 Finalizado: " + order4.toString());

        System.out.println("\n===== TESTE: PEDIDO COM FALHA NO PAGAMENTO =====");
        Order order5 = new Order("ORD-005", "Travessa E, 222 fail"); // Endereço com "fail"
        order5.addItem(new Item("Tablet", 1, new BigDecimal("500.00")));
        processor.process(order5);
        System.out.println("Pedido 5 Finalizado: " + order5.toString());

        System.out.println("\n===== TESTE: PEDIDO COM FALHA NO PAGAMENTO (VALOR ALTO) =====");
        Order order6 = new Order("ORD-006", "Alameda F, 333");
        order6.addItem(new Item("Carro", 1, new BigDecimal("150000.00"))); // Valor muito alto
        processor.process(order6);
        System.out.println("Pedido 6 Finalizado: " + order6.toString());

        System.out.println("\n--- Processamento de Pedidos Concluído ---");
    }
}