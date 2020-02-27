package app;

/**
 * Refrigerator
 */
public class Refrigerator extends Product{

    static int count1;
    int product_n = 2000;


    {
        product_n = ++count1;
    }

    Refrigerator(){
        price = 1500;
        name ="냉장고";
    }
    Refrigerator(String name){
        this.name = name;
      
    }
}