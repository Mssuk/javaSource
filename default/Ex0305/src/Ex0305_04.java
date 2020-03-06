import java.util.Calendar;
import java.util.Date;

public class Ex0305_04 {
    //2020년 3월 14일 15시39분 42초
    //2021년 4월 14일 12시59분 59초
    //며칠 몇시 몇분 몇초가 남았는지 계산하세요.

    public static void main(String[] args) {
        int[] time_unit = {24*60*60,60*60,60,1};
        String[] time_name = {"일","시","분","초"};
        String[] days_name = {"","일","월","화","수","목","금","토"};

        Calendar day1 = Calendar.getInstance();
        Calendar day2= Calendar.getInstance();
        day1.set(2020, Calendar.MARCH, 14, 15, 39, 42);
        day2.set(2021, Calendar.APRIL, 14, 12, 59, 59);


        long diffsec = Math.abs(day1.getTimeInMillis() -day2.getTimeInMillis())/1000;

        StringBuilder result= new StringBuilder();


        for(int i=0;i<time_unit.length;i++) {
            result.append(diffsec / time_unit[i]).append(time_name[i]);
            diffsec = diffsec % time_unit[i];
        }

        System.out.println("남은 시간 : "+result);

        System.out.println(day2.get(Calendar.DAY_OF_WEEK));
        System.out.println(days_name[day2.get(Calendar.DAY_OF_WEEK)] +"요일");
        System.out.println(day2.getTime());

    }

    
}
