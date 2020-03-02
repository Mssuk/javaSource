package app;

import java.util.Vector;

/**
 * Ex0302_01
 */
public class Ex0302_01 {

    public static void main(String[] args) {
        // 제품이라는 형태 - tv. com. audio
        
        //구매자 - 머니 보너스 구매목록 구매  환불 출력

        Buyer user = new Buyer(); //구매자 1명 생성

        user.buy(new Tv());
        user.buy(new Com());
        user.buy(new Audio());
        user.summary();
        


    } // main

} // class


class Buyer{
    int money = 10000;
    int bonus = 0;
    Vector<Product> cart = new Vector<>(); // 벡터
    //Product[] cart = new Product[10]; //배열 구조
    //int i =0;
    String listPrint="";



    void buy(Product p){

        if(money < p.price){
            System.out.println("잔액이 부족합니다. 충전해주세요.");
            return;
        }

        money = money - p.price;
        bonus = bonus + p.bonus;
        cart.add(p);
        System.out.println(p.name + "구매를 하였습니다.");
    }


    void summary(){
        // 구매목록 , 총 구매 금액
        int sum = 0;
        // cart가 빈공백인지 아닌지 확인
        if(cart.isEmpty()){
            return;
        }
        for(int i=0; i<cart.size() ;++i){
            Product p = cart.get(i);
            listPrint +=p.name+","; //tv ,com ,audio
            sum += p.price;
        } //for
        System.out.println("구매물품: "+listPrint);
        System.out.println("구매 총 금액: "+ sum);
        
    }


}



class Product {
    String name;
    int price;
    int bonus;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    Product(int price) {
        this.price = price;
        bonus = (int) (price * 0.3);
    }

}

class Tv extends Product {

    Tv() {
        super("Tv", 1000);
    }

}

class Com extends Product {
    Com() {
        super("Com", 900);
    }
}

class Audio extends Product {

    Audio() {
        super("Audio", 800);
    }
}