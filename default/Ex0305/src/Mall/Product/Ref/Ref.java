package Mall.Product.Ref;

import Mall.Product.Product;

public class Ref extends Product {
    Ref() {
        bonusRate = 0.4;
    }

    protected int liter;
    protected String door;
    protected boolean doubleCooling;

    @Override
    public String toString() {
        return
                String.format("종류:%s | 모델명:'%s' | 색상:%s | 용량:%d | 가격:%d", door, name, color, liter, price) +
                        (doubleCooling ? " | <기능: 더블쿨링>" : "");
    }
    @Override
    public String GetType() {
        return "냉장고";
    }

}
