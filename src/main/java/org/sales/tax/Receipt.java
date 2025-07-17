package org.sales.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Receipt {
    private final List<Item> items;
    private final double totalSalesTax;
    private final double totalCost;

    public void print() {
        for (Item item : items) {
            System.out.print(item.getQuantity() + " " + item.getName());
            System.out.printf(": %.2f%n", item.getTotalCost());
        }
        System.out.printf("Sales Taxes: %.2f%n", totalSalesTax);
        System.out.printf("Total: %.2f%n", totalCost);
    }
}
