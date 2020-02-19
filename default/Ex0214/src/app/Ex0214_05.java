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

        Scanner scan = new Scanner(System.in);
        //소수점 넷째자리에서 반올림.

        //float pi = 3.141592f;

        //float shortPi = (int)(Math.round(pi*1000)) /1000f;
        //System.out.println(shortPi);

        // System.out.println("소수 입력하시오.");
        // float num = scan.nextFloat();
        //  num = (Math.round(num * 1000))/ 1000f;
        //  System.out.println("넷째 자리에서 반올림 한 값:"+ num);

        //String str = String.format("%.3f", num);
        //System.out.println(Double.parseDouble(str));
        //System.out.printf("%.3f",num);


        //////////////////////////////////////////////////////////
        // System.out.println("소문자나 대문자 입력");
        // char ch = scan.next().charAt(0);
        // if(ch>='a' && ch<='z'){
        //     ch = (char)(ch - 32);
        // } else if(ch>='A' && ch<='Z') {
        //     ch = (char)(ch + 32);
        // } else {
        //     System.out.println("잘못 입력했습니다.");
        // }

        // System.out.println("변환 값: " + ch);
        //////////////////////////////////////////////////////////


        System.out.println("숫자 세개를 입력받아서 제일 큰 수 를 찾아보세요");
        int num[] = new int[3];
        for(int i=0; i<num.length; ++i){
            num[i] = scan.nextInt();
        }
        //삼항연산자
        // System.out.println(num[0] > num[1] ? (num[0] > num[2] ? "제일 큰 수 " + num[0] : "제일 큰 수 " + num[2])
        //         : (num[1] > num[2] ? "제일 큰 수 " + num[1] : "제일 큰 수 " + num[2]));
        
        int max = 0;
        //if문

        if(num[0]>=num[1] && num[0]>=num[2]) {
            max = num[0];
        } else if(num[1]>=num[0] && num[1]>=num[2]) {
            max = num[1];
        }else if(num[2]>=num[0] && num[2]>=num[1]) {
            max = num[2];
        } else {
            System.out.println("똑같은 수가 있습니다.");
        }

        System.out.println("최대값:" + max);








        
        System.out.println(max);
    }
}