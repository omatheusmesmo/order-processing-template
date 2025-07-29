package dev.omatheusmesmo.processing.handlers;

import dev.omatheusmesmo.domain.Order;

public abstract class OrderHandler {

    private OrderHandler nextHandler;

    public OrderHandler setNext(OrderHandler nextHandler){
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public final void handle(Order order){
        System.out.println("Iniciando processamento "+order.toString());

        if (processSpecificStep(order)){
            if (nextHandler != null){
                nextHandler.handle(order);
            }else{
                System.out.println("Nenhum manipulador na cadeia para o pedido.");
            }
        }else {
            System.out.println("Processamento interrompido.");
        }
        System.out.println("Processo concluído.");
    }

    protected abstract boolean processSpecificStep(Order order);
}