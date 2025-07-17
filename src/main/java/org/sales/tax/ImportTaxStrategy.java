package org.sales.tax;

public class ImportTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * Constants.IMPORT_DUTY;
    }
}
