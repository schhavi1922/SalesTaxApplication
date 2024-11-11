package org.sales.tax;

public class TaxCalculator {

    public static double calculateSalesTax(Item item) {
        double tax = 0;

        // Apply basic sales tax if not exempt
        if (!item.isTaxExempt()) {
            tax += item.getPrice() * Constants.BASIC_SALES_TAX;
        }

        // Apply import duty if item is imported
        if (item.isImported()) {
            tax += item.getPrice() * Constants.IMPORT_DUTY;
        }

        // Round tax to the nearest 0.05
        return roundTax(tax);
    }

    // Rounding up to the nearest 0.05
    private static double roundTax(double tax) {
        return Math.ceil(tax / Constants.TAX_ROUNDING_FACTOR) * Constants.TAX_ROUNDING_FACTOR;
    }
}
