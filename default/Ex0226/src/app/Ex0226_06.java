package app;

import java.util.Scanner;

/**
 * Ex0226_06
 */
public class Ex0226_06 {
    public static void main(String[] args) {

        // 시, 분, 초를 입력받아서 출력해보세요.
        // 잘못된 시를 입력했을때 다시 입력받아서 출력.

        Scanner scan = new Scanner(System.in);
        Time1 t = new Time1();
        do {
            System.out.println("시를 입력하세요");
            int temp = scan.nextInt();
            t.setHour(temp);
        } while (t.getHour() == -1);
        do {
            System.out.println("분를 입력하세요");
            int temp = scan.nextInt();
            t.setMinute(temp);
        } while (t.getMinute() == -1);
        do {
            System.out.println("초를 입력하세요");
            int temp = scan.nextInt();
            t.setSecond(temp);
        } while (t.getSecond() == -1);

        System.out.println(t);

        // Time1 t = new Time1();
        // Time1 t2 = new Time1(12,12,12);
        // t.setHour(10);
        // t.setMinute(65);
        // t.setSecond(12);

        // System.out.println(t);
        // System.out.println(t2);
    }

}

class Time1 {

    private int hour;
    private int minute;
    private int second;

    Time1() {
        this(-1, -1, -1);
    }

    Time1(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            System.out.println("잘못된 시간이 들어왔습니다.");
            return;
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            System.out.println("잘못된 분이 들어왔습니다.");
            return;
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            System.out.println("잘못된 초가 들어왔습니다.");
            return;
        }
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("{ %d 시 %d 분 %d 초 }", hour, minute, second);
    }

}