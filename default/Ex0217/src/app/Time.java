package app;

/**
 * Time
 */
public class Time {

    int hours;
    int minutes;
    float seconds;

    void print(){
        System.out.println("알람설정 : "+ hours + " 시"+ minutes+" 분"+ seconds + "초");
    }
}