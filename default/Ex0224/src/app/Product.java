package app;

/**
 * Product
 */
public class Product {

    static int count;
    int serialNum;
    String color; //white , black , red
    int tvInch; //42, 50, 72
    String standard; // LCD, LED, OLED

    // //초기화 블럭
    // {
    //     ++count;
    //     serialNum = count;
    // }

    Product(){
        count++;
        serialNum = count;
    }
    Product(String color, int tvInch, String standard){
        this.color = color; 
        this.tvInch = tvInch;
        this.standard = standard; 
    }

}