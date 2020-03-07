package Mall;

import Mall.Product.Product;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Purchase {
    private static int number;
    private int puNo;
    private String id;
    private String pName;
    private int pBonuspoint;
    private int pPrice;
    private String pDate;

    public Purchase(String id, String pName, int pBonuspoint, int pPrice){

        puNo = ++number;
        this.id = id;
        this.pName = pName;
        this.pBonuspoint = pBonuspoint;
        this.pPrice = pPrice;
        Calendar time = Calendar.getInstance();
        pDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time.getTime());
    }

    public int getpPrice() {
        return pPrice;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("구매번호:%d | 구매자:%s | 상품명:'%s' | 구매가격:%d | 적립포인트:%d | 구매일자:%s", puNo, id, pName, pPrice,pBonuspoint, pDate);
    }
}
