package app;

/**
 * Ex0228_02
 */
public class Ex0228_02 {

    public static void main(String[] args) {

        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());

        b.summary();
        /*
         * 1. tv구매 2.컴퓨터구매 3. 구매물품출력
         */
    }
}

class Buyer {

    int money = 100000;
    int bonusPoint = 0;
    // Tv[] tv_item =new Tv[10];
    // Computer[] com_item = new Computer[10];
    Product[] items = new Product[10];
    int itemIdx = 0;
    int sum = 0;

    void buy(Product p) {

        if (money < p.price) {
            System.out.println("금액이 부족합니다.");
            System.out.println("금액을 충전하세요.");
            return;
        }

        money = money - p.price;
        bonusPoint = bonusPoint + p.bonusPoint;
        items[itemIdx++] = p;

    }

    // 출력
    void summary() {
        for (int j = 0; j < itemIdx; ++j) {
            if (items[j] == null) {
                System.out.println("구매 물품이 없습니다.");
                continue;
            }
            System.out.print(items[j].name + " , ");
            sum = sum + items[j].price;
        }

        System.out.println("총 구매개수: " + (itemIdx));
        System.out.println("총 구매금액: " + sum);
        System.out.println("보유금액 : "+ money);
    }

}

class Product {
    String name;
    int price;
    int bonusPoint;

    Product() {

    }

    Product(String name, int price, int bonusPoint) {

        this.name = name;
        this.price = price;
        this.bonusPoint = bonusPoint;
    }

}

class Tv extends Product {

    Tv() {
        super("Tv", 1000, 1000 / 10);
        System.out.println("TV 한 대 구매");

    }
}

class Computer extends Product {

    Computer() {
        super("Computer", 900, 900 / 10);
        System.out.println("컴퓨터 한 대 구매");
    }
}