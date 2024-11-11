package org.sales.tax;

import java.util.Set;

public class Constants {

    static final double BASIC_SALES_TAX = 0.10;

    static final double IMPORT_DUTY = 0.05;

    static final double TAX_ROUNDING_FACTOR = 0.05;

    static final Set<String> taxExemptItems = Set.of("book", "novel", "textbook", "comic", "biography", "dictionary",
            "magazine", "anthology", "encyclopedia", "journal", "thriller", "chocolate", "biscuit", "apple", "banana",
            "bread", "rice", "cheese", "pasta", "yogurt", "salad", "pill", "aspirin", "syringe", "stethoscope",
            "antibiotic", "bandage", "vaccine", "thermometer", "x-ray", "insulin", "crutches"
    );
}
