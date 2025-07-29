package dev.omatheusmesmo.processing.handlers;

import dev.omatheusmesmo.domain.Order;

import java.math.BigDecimal;

public class PaymentHandler extends OrderHandler {

    @Override
    protected boolean processSpecificStep(Order order) {
        System.out.println("[PaymentHandler] Processando pagamento para o pedido " + order.orderId + "...");

        if (order.totalValue.compareTo(new BigDecimal("1000.00")) > 0 || order.address.contains("fail")) {
            order.paid = false; // Define o campo público 'paid'
            System.err.println("[PaymentHandler] ERRO: Falha no pagamento para o pedido " + order.orderId + ". Valor alto ou endereço inválido.");
            return false;
        } else {
            order.paid = true; // Define o campo público 'paid'
            System.out.println("[PaymentHandler] Pagamento do pedido " + order.orderId + " processado com sucesso.");
            return true;
        }
    }
}
