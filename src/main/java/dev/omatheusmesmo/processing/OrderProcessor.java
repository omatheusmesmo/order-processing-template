package dev.omatheusmesmo.processing;

import dev.omatheusmesmo.domain.Order;
import dev.omatheusmesmo.processing.handlers.OrderHandler;
import dev.omatheusmesmo.processing.handlers.PaymentHandler;
import dev.omatheusmesmo.processing.handlers.ShippingHandler;
import dev.omatheusmesmo.processing.handlers.ValidationHandler;

public class OrderProcessor {

    private OrderHandler chain;

    public OrderProcessor(){

        OrderHandler validationHandler = new ValidationHandler();
        OrderHandler shippingHandler = new ShippingHandler();
        OrderHandler paymentHandler = new PaymentHandler();

        validationHandler
                .setNext(shippingHandler)
                .setNext(paymentHandler);

        this.chain = validationHandler;
    }

    public void process(Order order){
        System.out.println("\n--- Iniciando Processamento do Pedido: " + order.toString() + " ---");
        chain.handle(order);
        System.out.println("--- Processamento do Pedido " + order.toString() + " Concluído ---");
        System.out.println("Status Final do Pedido: " + order + "\n");
    }
}
