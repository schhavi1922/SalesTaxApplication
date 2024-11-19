package org.sales.tax;

import java.util.Scanner;

public class SalesTaxApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingBasket basket = new ShoppingBasket();

        System.out.println("Enter all items, one per line (format: 'quantity name at price').");
        System.out.println("Press Enter twice when all items are added:");

        String[] lines = collectInput(scanner);

        for (String line : lines) {
            try {
                Item item = ItemParser.parseItem(line);
                double tax = TaxCalculator.calculateSalesTax(item);

                item.setSalesTax(tax);
                item.setTotalCost(item.getTotalCost() + tax);
                basket.addItem(item);
            } catch (InvalidItemFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nReceipt:");
        Receipt receipt = basket.generateReceipt();
        receipt.print();
        scanner.close();
    }

    private static String[] collectInput(Scanner scanner) {
        StringBuilder inputLines = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            inputLines.append(line).append("\n");
        }
        return inputLines.toString().split("\n");
    }

}