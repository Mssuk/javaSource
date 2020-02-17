package app;

import java.util.Scanner;

/**
 * Ex0217_04 시, 분, - int [24, 60] 초 - float[소수점 첫째자리 까지] 10개의 hours을 입력받는다 배열을
 * 선언해서 받으세요.
 */
public class Ex0217_04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Time[] t = new Time[3];
        // int[] hours = new int[10];
        // int[] minutes = new int[10];
        // float[] seconds =new float[10];
        int flag = 0;

        System.out.println("[알람]");
        for (int i = 0; i < t.length; ++i) {
            t[i] = new Time();
            if (flag == 0) {
                System.out.println(i + 1 + " 번째 알람");
                System.out.println("몇 시?");
                t[i].hours = scan.nextInt();
                if (t[i].hours < 0 || t[i].hours > 24) {
                    i--;
                    continue;
                }
                flag++;
            }
            if (flag == 1) {
                System.out.println("몇 분?");
                t[i].minutes = scan.nextInt();
                if (t[i].minutes < 0 || t[i].minutes > 60) {
                    i--;
                    continue;
                }
                flag++;
            }
            if (flag == 2) {
                System.out.println("몇 초?");
                t[i].seconds = scan.nextFloat();
                if (t[i].seconds < 0 || t[i].seconds > 60) {
                    i--;
                    continue;
                }
            }
            flag = 0;
        }

        for (int i = 0; i < 10; ++i) {
            System.out.printf("%d 번째 알람 : %d시 %d 분 %.1f초%n", i + 1, t[i].hours, t[i].minutes, t[i].seconds);
        }

    }
}