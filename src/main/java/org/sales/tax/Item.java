package org.sales.tax;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {
    private final String name;
    private final double price;
    private final int quantity;
    
    @Setter
    private double salesTax;
    
    @Setter
    private double totalCost;
}
