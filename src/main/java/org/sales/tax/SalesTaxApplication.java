package org.sales.tax;

import java.util.Scanner;

public class SalesTaxApplication {

    public static void main(String[] args) throws InvalidItemFormatException {
        Scanner scanner = new Scanner(System.in);
        ShoppingBasket basket;

        System.out.println("Enter all items, one per line (format: 'quantity name at price').");
        System.out.println("Please enter twice once all items are added");

        String[] lines = collectInput(scanner);

        basket = processInput(lines);

        // Print the receipt
        System.out.println("\nReceipt:");
        basket.printReceipt();

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

    private static ShoppingBasket processInput(String[] lines) throws InvalidItemFormatException {
        ShoppingBasket basket = new ShoppingBasket();
        for (String itemLine : lines) {
            int firstSpaceIndex = itemLine.indexOf(" ");
            int atIndex = itemLine.lastIndexOf(" at ");

            if (firstSpaceIndex == -1 || atIndex == -1 || firstSpaceIndex >= atIndex) {
                throw new InvalidItemFormatException("Invalid input format: " + itemLine);
            }

            // Extract quantity
            int quantity;
            try {
                quantity = Integer.parseInt(itemLine.substring(0, firstSpaceIndex).trim());
            } catch (NumberFormatException e) {
                throw new InvalidItemFormatException("Invalid quantity: " + itemLine);
            }

            // Extract description and price
            String description = itemLine.substring(firstSpaceIndex + 1, atIndex).trim();
            double pricePerUnit;
            try {
                pricePerUnit = Double.parseDouble(itemLine.substring(atIndex + 4).trim());
            } catch (NumberFormatException e) {
                throw new InvalidItemFormatException("Invalid price: " + itemLine);
            }

            // Add item to basket with description, price, and quantity
            basket.addItem(description, pricePerUnit, quantity);
        }
        return basket;
    }
}