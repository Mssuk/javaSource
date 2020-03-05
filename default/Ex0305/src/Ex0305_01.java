import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex0305_01 {

    public static void main(String[] args) {
        Calendar today= Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("포맷없는 일시출력:"+ today.getTime());
        System.out.println("포맷있는 일시출력:"+format1.format(today.getTime()));

    }
}
