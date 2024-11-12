package org.sales.tax;

public class ShoppingBasket {

    private final Receipt receipt = new Receipt();

    // Method to add items to the basket
    public void addItem(String description, double price, int quantity) {
        boolean isImported = description.contains("imported");
        boolean isTaxExempt = isExempt(description);
        Item item = new Item(description, price, isImported, isTaxExempt, quantity);
        receipt.addItem(item);
    }

    public void add(Item item) {
        receipt.addItem(item);
    }

    // Method to check if the item is exempt from basic sales tax
    private boolean isExempt(String description) {
        for (String exempt : Constants.taxExemptItems) {
            if (description.contains(exempt)) {
                return true;
            }
        }
        return false;
    }

    public void printReceipt() {
        receipt.generateReceipt();
    }
}
