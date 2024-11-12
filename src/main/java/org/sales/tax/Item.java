package org.sales.tax;

public class Item {

    private String name;

    private double price;

    private int quantity;

    private double salesTax;

    private double totalCost;

    private boolean isImported;

    private boolean isTaxExempt;


    public Item(String name, double price, boolean isImported, boolean isTaxExempt, int quantity) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isTaxExempt = isTaxExempt;
        this.quantity = quantity;
        this.salesTax = calculateSalesTax();
        this.totalCost = (price * quantity) + salesTax;
    }

    public double calculateSalesTax() {
        double tax = 0;
        if (this.isTaxExempt()) {
            tax += (this.getPrice() * this.getQuantity()) * Constants.BASIC_SALES_TAX;
        }
        if (this.isImported()) {
            tax += (this.getPrice() * this.getQuantity()) * Constants.IMPORT_DUTY;
        }
        return roundTax(tax);
    }

    private static double roundTax(double tax) {
        return Math.ceil(tax / Constants.TAX_ROUNDING_FACTOR) * Constants.TAX_ROUNDING_FACTOR;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxExempt() {
        return !isTaxExempt;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
