package org.sales.tax;

import java.util.Scanner;

public class SalesTaxApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            ShoppingBasket basket = new ShoppingBasket();
            
            System.out.println("\n=== New Receipt ===");
            System.out.println("Enter all items, one per line (format: 'quantity name at price').");
            System.out.println("Press Enter twice when all items are added.");
            System.out.println("Type 'exit' to quit the application.");

            String[] lines = collectInput(scanner);
            
            if (lines.length == 1 && lines[0].equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using Sales Tax Calculator. Goodbye!");
                break;
            }

            for (String line : lines) {
                try {
                    Item item = ItemParser.parseItem(line);
                    double tax = TaxCalculator.calculateSalesTax(item);

                    item.setSalesTax(tax);
                    item.setTotalCost(item.getPrice() + tax);
                    basket.addItem(item);
                } catch (InvalidItemFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println("\nReceipt:");
            Receipt receipt = basket.generateReceipt();
            receipt.print();
            
            System.out.println("\nPress Enter to continue or type 'exit' to quit...");
            scanner.nextLine(); // Wait for user to press Enter
        }
        
        scanner.close();
    }

    private static String[] collectInput(Scanner scanner) {
        StringBuilder inputLines = new StringBuilder();
        String line;
        
        // Read lines until we get an empty line
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            inputLines.append(line).append("\n");
        }
        
        return inputLines.toString().split("\n");
    }
}