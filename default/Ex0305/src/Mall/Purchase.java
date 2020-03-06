package Mall;

import Mall.Product.Product;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Purchase {
    private static int number;
    private static int pNo;
    private String id;
    private String pName;
    private int point;
    private String pDate;

    public Purchase(String id, String pName, int point){

        pNo = number;
        this.id = id;
        this.pName = pName;
        this.point = point;
        Calendar time = Calendar.getInstance();
        pDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time.getTime());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", pName='" + pName + '\'' +
                ", point=" + point +
                ", pDate='" + pDate + '\'' +
                '}';
    }
}
