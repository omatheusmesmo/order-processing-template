package dev.omatheusmesmo.processing.handlers;

import dev.omatheusmesmo.domain.Order;
import java.math.BigDecimal;

public class ShippingHandler extends OrderHandler {

    @Override
    protected boolean processSpecificStep(Order order) {
        System.out.println("[ShippingHandler] Calculando frete para o pedido " + order.orderId + "...");

        BigDecimal calculatedShippingCost;

        if (order.totalValue.compareTo(new BigDecimal("200.00")) > 0) {
            calculatedShippingCost = BigDecimal.ZERO;
            System.out.println("[ShippingHandler] Frete grátis aplicado para o pedido " + order.orderId + ".");
        } else {
            calculatedShippingCost = new BigDecimal("25.00");
            System.out.println("[ShippingHandler] Custo de frete de R$ " + calculatedShippingCost + " para o pedido " + order.orderId + ".");
        }

        order.shippingCost = calculatedShippingCost;

        return true;
    }
}