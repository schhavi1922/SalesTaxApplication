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
        StringBuilder receiptDetails = new StringBuilder();
        for (Item item : items) {
            double salesTax = TaxCalculator.calculateSalesTax(item);
            double finalPrice = item.getPrice() + salesTax;
            receiptDetails.append(String.format("%d %s: %.2f\n", 1, item.getName(), finalPrice));
            totalSalesTax += salesTax;
            totalCost += finalPrice;
        }

        receiptDetails.append(String.format("Sales Taxes: %.2f\n", totalSalesTax));
        receiptDetails.append(String.format("Total: %.2f", totalCost));
        System.out.println(receiptDetails);
    }
}
