package app;

/**
 * Aircon
 */
public class Aircon extends Product {

    static int count2;
    int product_n = 3000;

    {
        product_n = ++count2;

    }
    Aircon(){
        price = 900;
        name = "에어컨";
    }
}