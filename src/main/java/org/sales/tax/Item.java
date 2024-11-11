package org.sales.tax;

public class Item {

    private String name;

    private double price;

    private boolean isImported;

    private boolean isTaxExempt;

    public Item(String name, double price, boolean isImported, boolean isTaxExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isTaxExempt = isTaxExempt;
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
        return isTaxExempt;
    }
}
