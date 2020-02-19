package app;

import java.util.Scanner;

/**
 * Ex0217_02 4. 대문자 입력시 소문자 출력 프로그램
 * 
 * ( 기본 – 대문자만 1개 입력시 소문자로 변환 )
 * 
 * ( 옵션 – 대문자 입력시 소문자로, 소문자 입력시 대문자로 문자열 입력 가능 )
 */
public class Ex0217_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("[영문자변환기] 문자열을 입력하세요");

        String str = "";
        str = scan.next();

        System.out.print("변환된 문자:");
        for (int i = 0; i < str.length(); ++i) {
            char munja = str.charAt(i);
            if (munja >= 'a' && munja <= 'z') {
                munja -= 32;
            } else if (munja >= 'A' && munja <= 'Z') {
                munja += 32;
            }
            System.out.print(munja);
        }

    }
}