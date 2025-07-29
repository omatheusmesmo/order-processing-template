package dev.omatheusmesmo.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public String orderId;
    public List<Item> items;
    public BigDecimal totalValue;
    public String address;
    public BigDecimal shippingCost;
    public Boolean valid;
    public Boolean paid;


    public Order(String orderId, String address) {
        this.orderId = orderId;
        this.address = address;
        this.items = new ArrayList<>();
        this.totalValue = BigDecimal.ZERO;
        this.shippingCost = BigDecimal.ZERO;
        this.valid = false;
        this.paid = false;
    }

    // Método para adicionar itens e atualizar o valor total
    public void addItem(Item item) {
        if (item != null) {
            this.items.add(item);

            this.totalValue = this.totalValue.add(item.value.multiply(new BigDecimal(item.quantity)));
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", items=" + items +
                ", totalValue=" + totalValue +
                ", address='" + address + '\'' +
                ", shippingCost=" + shippingCost +
                ", valid=" + valid +
                ", paid=" + paid +
                '}';
    }
}