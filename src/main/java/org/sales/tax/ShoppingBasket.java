package org.sales.tax;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Receipt generateReceipt() {
        double sumSalesTax = 0.0;
        double sumCost = 0.0;
        for (Item item : items) {
            sumSalesTax += item.getSalesTax();
            sumCost += item.getTotalCost();
        }
        return new Receipt(items, sumSalesTax, sumCost);
    }
}
