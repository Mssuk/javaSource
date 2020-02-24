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

    //초기화 블럭 (생성자의 공통부분을 하나로 뽑아낼 수있다.)
    {
        ++count;
        serialNum = count;
    }

    Product(){

    }
    Product(String color, int tvInch, String standard){
        this.color = color; 
        this.tvInch = tvInch;
        this.standard = standard; 
    }
    Product(String color){

    }

}