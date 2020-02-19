package app;

import java.util.Scanner;

/**
 * Ex0219_01
 */

public class Ex0219_01 {
    public static void main(String[] args) {
        // 사칙 연산 프로그램

        Scanner scan = new Scanner(System.in);
        int input1 = 0, input2 = 0;

        while (true) {
            System.out.println(" [ 사칙연산 프로그램 ] ");
            System.out.println("1.) 더하기 2.) 빼기");
            System.out.println(" 해당하는 프로그램을 선택하세요>>");

            switch (scan.nextInt()) {
                case 1:
                    System.out.println("더하기 프로그램");
                    System.out.println("더하고 싶은 첫 번째 숫자를 입력하세요.>>");
                    input1 = scan.nextInt();
                    System.out.println("더하고 싶은 두 번째 숫자를 입력하세요.>>");
                    input2 = scan.nextInt();
                    int result = Ex0219_01.add(input1, input2);
                    System.out.println("결과값:" + result);
                    break;

                case 2:
                    System.out.println("빼기 프로그램");
                    System.out.println("빼고 싶은 첫 번째 숫자를 입력하세요.>>");
                    input1 = scan.nextInt();
                    System.out.println("빼고 싶은 두 번째 숫자를 입력하세요.>>");
                    input2 = scan.nextInt();
                    System.out.println("결과값:" + sub(input1, input2));
                    break;

                default:
                    break;
            }
        }
    } // main

    // 더하기 method
    static int add(int a, int b) {
        int result = 0;
        result = a + b;
        // 넘어갈 때 result변수가 넘어가지 않고 값이 넘어간다.
        return result;
    }

    static int sub(int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }
} // class
