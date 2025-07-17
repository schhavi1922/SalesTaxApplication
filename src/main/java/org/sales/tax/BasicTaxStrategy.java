package org.sales.tax;

public class BasicTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * Constants.BASIC_SALES_TAX;
    }
}
