package org.sales.tax;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Item> items;
    private double totalSalesTax = 0;
    private double totalCost = 0;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void generateReceipt() {
        calculateTotals();

        StringBuilder receiptDetails = new StringBuilder();
        for (Item item : items) {
            receiptDetails.append(String.format("%d %s: %.2f\n", item.getQuantity(),
                    item.getName(), item.getTotalCost()));
        }
        receiptDetails.append(String.format("Sales Taxes: %.2f\n", totalSalesTax));
        receiptDetails.append(String.format("Total: %.2f", totalCost));
        printReceipt(receiptDetails.toString());
    }

    private void calculateTotals() {
        totalSalesTax = 0;
        totalCost = 0;

        for (Item item : items) {
            totalSalesTax += item.getSalesTax();
            totalCost += (item.getPrice() * item.getQuantity()) + item.getSalesTax();
        }
    }

    public void printReceipt(String receiptDetail) {
        System.out.println(receiptDetail);
    }
}
