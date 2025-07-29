package dev.omatheusmesmo.domain;

import java.math.BigDecimal;

public class Item {
    public String item;
    public Integer quantity;
    public BigDecimal value;

    public Item(String item, Integer quantity, BigDecimal value) {
        this.item = item;
        this.quantity = quantity;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{item='" + item + "', quantity=" + quantity + ", value=" + value + '}';
    }
}