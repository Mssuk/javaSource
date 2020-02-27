package app;

/**
 * SamsungTv
 */
public class SamsungTv {

    static int count;
    int product_n = 1000;
    String name;
    int tv_inch;
    int price = 1000;

    // 초기화 블럭
    {
        product_n = ++count;
    }

    SamsungTv() {

    }

    SamsungTv(String name, int tv_inch, int price) {
        this.name = name;
        this.tv_inch = tv_inch;
        this.price = price;
    }

}