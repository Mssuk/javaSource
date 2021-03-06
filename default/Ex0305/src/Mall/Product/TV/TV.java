package Mall.Product.TV;

import Mall.Product.Product;

public class TV extends Product {
    TV(){
        bonusRate = 0.3;
    }
    protected String screen;
    protected int inch;
    protected boolean hdr;

    @Override
    public String toString() {
        return String.format("화면:%s | 모델명:'%s' | 색상:%s | 인치:%d | 가격:%d", screen, name, color, inch, price) +
                        (hdr ? " | <기능: hdr>" : "");
    }
    @Override
    public String GetType() {
        return "TV";
    }
}
