import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex0305_01 {

    public static void main(String[] args) {
        Calendar today= Calendar.getInstance();


        Calendar today2= Calendar.getInstance();
        today2.set(Calendar.YEAR, 2021);
        today2.set(Calendar.MONTH, 3);
        today2.set(Calendar.DATE, 14);
        today2.set(Calendar.HOUR, 11);
        today2.set(Calendar.MINUTE, 59);
        today2.set(Calendar.SECOND, 58);

        System.out.println(today2.get(Calendar.YEAR));
        System.out.println(today2.get(Calendar.MONTH));
        System.out.println(today2.get(Calendar.DATE));
        System.out.println(today2.get(Calendar.HOUR));
        System.out.println(today2.get(Calendar.MINUTE));
        System.out.println(today2.get(Calendar.SECOND));
        System.out.println(today2.getTimeInMillis());


        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("포맷없는 일시출력:"+ today.getTime());
        System.out.println("포맷있는 일시출력:"+format1.format(today.getTime()));


        System.out.println("현재 시간을 밀리세컨드로 표시:"+ today.getTimeInMillis());

        int year = today.get(Calendar.YEAR);
        System.out.println("년도:"+year);
        int month = today.get(Calendar.MONTH);
        System.out.println("현재 월"+ (month+1));
        int date = today.get(Calendar.DATE);
        System.out.println("현재 일"+ date);


        String d_day= "2020-03-14 11:59:59";
        try {
            Date enddate = format1.parse(d_day);
            System.out.println("직접입력일시:"+ enddate.getTime());
            long between = today.getTimeInMillis()-enddate.getTime();
            System.out.println("long 타입변수 :"+ between);
            System.out.println("현재시간과 직접입력시간 차이: "+Math.abs(today.getTimeInMillis()-enddate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
