package app;

import java.util.Scanner;

/**
 * Ex0214_05
 * 
 * 
 * <필기> 
 * 16진수 ->2진수
 * 로또
 * 
 * <실기>
 * 성적관리프로그램
 * 
 * 
 */
public class Ex0214_05 {

    public static void main(String[] args) {
        //소수점 넷째자리에서 반올림.

        //float pi = 3.141592f;

        //float shortPi = (int)(Math.round(pi*1000)) /1000f;
        //System.out.println(shortPi);

        Scanner scan = new Scanner(System.in);
        System.out.println("소수 입력하시오.");
        float num = scan.nextFloat();
        // num = (int)(Math.round(num * 1000))/ 1000f;
        // System.out.println("넷째 자리에서 반올림 한 값:"+ num);

        String str = String.format("%.3f", num);
        System.out.println(Double.parseDouble(str));
        //System.out.printf("%.3f",num);
    }
}