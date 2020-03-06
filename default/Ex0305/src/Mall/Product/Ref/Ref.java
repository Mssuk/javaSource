package Mall.Product.Ref;

import Mall.Product.Product;

public abstract class Ref extends Product {
    Ref() {
        bonusRate = 0.4;
    }

    protected int liter;
    protected String door;

    @Override
    public String toString() {
        return
                String.format("종류:%s | 모델명:'%s' | 색상:%s | 용량:%d | 가격:%d", door, name, color, liter, price);
    }

}
