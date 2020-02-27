package app;

/**
 * Product
 */
public class Product {

    /*
        * price 900 : 에어컨
        * price 1500 : 냉장고
        * price 1000 : 삼성TV
    */

    int price = 0;
    String name;
    
    Product(){

    }

    Product(int price){
        this.price = price;
    }

}