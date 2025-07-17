package org.sales.tax;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TaxCalculator {
    private static final TaxStrategy BASIC_TAX_STRATEGY = new BasicTaxStrategy();
    private static final TaxStrategy IMPORT_TAX_STRATEGY = new ImportTaxStrategy();

    public double calculateSalesTax(Item item) {
        double tax = 0;

        // Calculate basic tax if item is not exempt
        if (!isItemTaxExempted(item)) {
            tax += BASIC_TAX_STRATEGY.calculateTax(item.getPrice());
        }

        // Calculate import tax if item is imported
        if (isItemImported(item)) {
            tax += IMPORT_TAX_STRATEGY.calculateTax(item.getPrice());
        }

        return roundToNearest(tax);
    }

    private boolean isItemTaxExempted(Item item) {
        return Constants.taxExemptItems.stream()
                .anyMatch(exemptItem -> item.getName().toLowerCase().contains(exemptItem));
    }

    private boolean isItemImported(Item item) {
        return item.getName().toLowerCase().contains("imported");
    }

    private double roundToNearest(double tax) {
        return Math.ceil(tax / Constants.TAX_ROUNDING_FACTOR) * Constants.TAX_ROUNDING_FACTOR;
    }
}
