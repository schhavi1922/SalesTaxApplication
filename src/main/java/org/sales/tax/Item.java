package org.sales.tax;

public class Item {

    private final String name;

    private final double price;

    private final int quantity;

    private double salesTax;

    private double totalCost;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = price * quantity;
    }

    public String getName() {
        return name;
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

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
