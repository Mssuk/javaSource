package Mall.Product.Washer;

import Mall.Product.Product;

public abstract class Washer extends Product {
    Washer() {
        bonusRate = 0.7;
    }

    protected int size;
    protected String shape;

    @Override
    public String toString() {
        return
                String.format("타입:%s | 모델명:'%s' | 색상:%s | 용량:%d | 가격:%d", shape, name, color, size, price);
    }
}
