import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex0305_02 {
    public static void main(String[] args) {
        //2020-03-05 출력을 하시오.
        //2020년 3월 5일 목요일

        Calendar today = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2= new SimpleDateFormat("yyyy년 M월 d일");

        System.out.println("현재 날짜 시간 출력");
        System.out.println(format.format(today.getTime()));


        String hanDay= format2.format(today.getTime());
        int day = today.get(Calendar.DAY_OF_WEEK);


        switch (day){
            case 1:
                hanDay += " 일요일";
                break;
            case 2:
                hanDay += " 월요일";
                break;
            case 3:
                hanDay += " 화요일";
                break;
            case 4:
                hanDay += " 수요일";
                break;
            case 5:
                hanDay += " 목요일";
                break;
            case 6:
                hanDay += " 금요일";
                break;
            case 7:
                hanDay += " 토요일";
                break;

        }
        System.out.println(hanDay);


    }
}
