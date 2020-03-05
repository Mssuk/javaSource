import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Ex0305_03 {
    public static void main(String[] args) throws ParseException {
        /*
         * 현재 시간에서
         * 2020년 7월 24일 금요일 11:59:59
         * 현재까지 며칠 몇분 몇초가 남았나요.
         *
         * */

        Calendar today = Calendar.getInstance();
        long current = today.getTimeInMillis();

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d_day = "2020-07-24 11:59:59";
        Date endDate = format1.parse(d_day);

        long left = endDate.getTime() - current;

        String result ="";





    }
}
