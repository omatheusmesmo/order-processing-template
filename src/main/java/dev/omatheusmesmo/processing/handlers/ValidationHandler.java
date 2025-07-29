package dev.omatheusmesmo.processing.handlers;

import dev.omatheusmesmo.domain.Order;
import java.math.BigDecimal;

public class ValidationHandler extends OrderHandler {

    @Override
    protected boolean processSpecificStep(Order order) {
        System.out.println("[ValidationHandler] Validando pedido " + order.orderId + "...");


        if (order.totalValue.compareTo(BigDecimal.ZERO) > 0 && order.address != null && !order.address.isEmpty()) {
            order.valid = true;
            System.out.println("[ValidationHandler] Pedido " + order.orderId + " validado com sucesso.");
            return true;
        } else {
            order.valid = false;
            System.err.println("[ValidationHandler] ERRO: Pedido " + order.orderId + " é inválido (valor total zero ou endereço ausente).");
            return false;
        }
    }
}