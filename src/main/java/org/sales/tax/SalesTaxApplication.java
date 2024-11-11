package org.sales.tax;

public class SalesTaxApplication {
    public static void main(String[] args) {

        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.addItem("book", 12.49);
        basket1.addItem("music CD", 14.99);
        basket1.addItem("chocolate bar", 0.85);
        System.out.println("Output 1:");
        basket1.printReceipt();
        System.out.println();

        // Input 2
        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.addItem("imported box of chocolates", 10.00);
        basket2.addItem("imported bottle of perfume", 47.50);
        System.out.println("Output 2:");
        basket2.printReceipt();
        System.out.println();

        // Input 3
        ShoppingBasket basket3 = new ShoppingBasket();
        basket3.addItem("imported bottle of perfume", 27.99);
        basket3.addItem("bottle of perfume", 18.99);
        basket3.addItem("packet of headache pills", 9.75);
        basket3.addItem("box of imported chocolates", 11.25);
        System.out.println("Output 3:");
        basket3.printReceipt();
    }
}