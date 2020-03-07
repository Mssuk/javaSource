package Mall.Product.Washer;

import Mall.Product.Product;

public class Washer extends Product {
    Washer() {
        bonusRate = 0.7;
    }

    protected int size;
    protected String shape;
    protected boolean sterilization;
    @Override
    public String toString() {
        return String.format("종류:%s | 모델명:'%s' | 색상:%s | 용량:%d | 가격:%d", shape, name, color, size, price) +
                (sterilization ? " | <기능: 살균>" : "");
    }

    @Override
    public String GetType() {
        return "세탁기";
    }
}
