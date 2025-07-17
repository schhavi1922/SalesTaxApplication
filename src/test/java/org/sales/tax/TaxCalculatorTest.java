package org.sales.tax;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import lombok.val;

class TaxCalculatorTest {
    
    @Test
    @DisplayName("Basic tax calculation for non-exempt item")
    void testBasicTaxCalculation() {
        val item = new Item("music CD", 14.99, 1);
        val tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(1.50, tax, 0.01);
    }

    @Test
    @DisplayName("Imported tax calculation for imported item")
    void testImportedTaxCalculation() {
        val item = new Item("imported perfume", 47.50, 1);
        val tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(7.15, tax, 0.01);
    }

    @Test
    @DisplayName("Tax exempt item calculation")
    void testTaxExemptItem() {
        val item = new Item("book", 12.49, 1);
        val tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(0.0, tax, 0.01);
    }

    @Test
    @DisplayName("Imported tax exempt item calculation")
    void testImportedTaxExemptItem() {
        val item = new Item("imported chocolate", 10.00, 1);
        val tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(0.50, tax, 0.01);
    }

    @Test
    @DisplayName("Tax rounding verification")
    void testRounding() {
        val item = new Item("perfume", 18.99, 1);
        val tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(1.90, tax, 0.01);
    }
}
