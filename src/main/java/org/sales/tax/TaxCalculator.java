package org.sales.tax;

public class TaxCalculator {

    public static double calculateSalesTax(Item item) {
        double tax = 0;

        if (!isItemTaxExempted(item)) {
            System.out.println(item.getName() + " plus basic tax");
            tax += item.getTotalCost() * Constants.BASIC_SALES_TAX;
        }

        if (isItemImported(item)) {
            System.out.println(item.getName() + " plus imported tax");
            tax += item.getTotalCost() * Constants.IMPORT_DUTY;
        }

        return roundToNearest(tax);
    }

    private static boolean isItemTaxExempted(Item item) {
        for (String exemptItem : Constants.taxExemptItems) {
            if (item.getName().contains(exemptItem)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isItemImported(Item item) {
        return item.getName().contains("import");
    }

    private static double roundToNearest(double tax) {
        return Math.ceil(tax / Constants.TAX_ROUNDING_FACTOR) * Constants.TAX_ROUNDING_FACTOR;
    }
}
