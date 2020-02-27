package app;

/**
 * SamsungTv
 */
public class SamsungTv extends Product{

    static int count;
    int product_n = 1000;
    int tv_inch;


    // 초기화 블럭
    {
        product_n = ++count;
    }

    SamsungTv() {
        price = 1000;
        name = "TV";
    }

    SamsungTv(String name, int tv_inch, int price) {
        this.name = name;
        this.tv_inch = tv_inch;
    }

}