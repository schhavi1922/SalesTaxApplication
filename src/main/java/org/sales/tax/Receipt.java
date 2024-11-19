package org.sales.tax;

import java.util.List;

public class Receipt {

    private final List<Item> items;
    private final double totalSalesTax;
    private final double totalCost;

    public Receipt(List<Item> items, double totalSalesTax, double totalCost) {
        this.items = items;
        this.totalSalesTax = totalSalesTax;
        this.totalCost = totalCost;
    }

    public void print() {
        System.out.println("Sales Receipt");
        System.out.println("------------");
        for (Item item : items) {
            System.out.print(item.getQuantity() + " " + item.getName());
            System.out.printf(": %.2f%n", item.getTotalCost());
        }
        System.out.printf("Sales Tax: %.2f%n", totalSalesTax);
        System.out.printf("Total Cost: %.2f%n", totalCost);
        System.out.println("------------");
    }
}
