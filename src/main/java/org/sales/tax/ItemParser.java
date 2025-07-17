package org.sales.tax;

public class ItemParser {

    public static Item parseItem(String itemLine) throws InvalidItemFormatException {
        int firstSpaceIndex = itemLine.indexOf(" ");
        int atIndex = itemLine.lastIndexOf(" at ");

        if (firstSpaceIndex == -1 || atIndex == -1 || firstSpaceIndex >= atIndex) {
            throw new InvalidItemFormatException("Invalid input format: " + itemLine);
        }

        int quantity;
        try {
            quantity = Integer.parseInt(itemLine.substring(0, firstSpaceIndex).trim());
        } catch (NumberFormatException e) {
            throw new InvalidItemFormatException("Invalid quantity: " + itemLine);
        }

        String description = itemLine.substring(firstSpaceIndex + 1, atIndex).trim();
        double pricePerUnit;
        try {
            pricePerUnit = Double.parseDouble(itemLine.substring(atIndex + 4).trim());
        } catch (NumberFormatException e) {
            throw new InvalidItemFormatException("Invalid price: " + itemLine);
        }

        return new Item(description, pricePerUnit, quantity);
    }

}
