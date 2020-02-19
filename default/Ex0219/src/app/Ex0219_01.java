package app;

import java.util.Scanner;

/**
 * Ex0219_01
 */

public class Ex0219_01 {
    public static void main(String[] args) {
        // 사칙 연산 프로그램
        Scanner scan = new Scanner(System.in);
        int[] input = new int[2];
        int result;

        while (true) {
            System.out.println(" [ 사칙연산 프로그램 ] ");
            System.out.println("1.) 더하기 2.) 빼기 3.) 곱하기 4.) 나누기");
            System.out.println(" 해당하는 프로그램을 선택하세요>>");

            switch (scan.nextInt()) {
                case 1:
                    print(input);
                    System.out.println("더하기 프로그램");
                    add(input[0], input[1]);
                    break;

                case 2:
                    print(input);
                    System.out.println("빼기 프로그램");
                    sub(input[0], input[1]);
                    break;

                case 3:
                    print(input);
                    System.out.println("곱하기 프로그램");

                    result = mul(input[0], input[1]);
                    System.out.println("결과값:" + result);
                    break;

                case 4:
                    System.out.println("나누기 프로그램");

                    Ex0219_01.div(input[0], input[1]);
                    break;

                default:
                    break;
            }
        }
    } // main

    // 프린트 메소드
    static void print(int[] input) {

        Scanner scan = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요.>>");
        input[0] = scan.nextInt();
        System.out.println("두 번째 숫자를 입력하세요.>>");
        input[1] = scan.nextInt();

    }

    // 더하기 method
    static void add(int a, int b) {
        int result = 0;
        result = a + b;
        // 넘어갈 때 result변수가 넘어가지 않고 값이 넘어간다.

        System.out.println("결과값:" + result);

    }

    static void sub(int a, int b) {
        int result = 0;
        if (a > b) {
            result = a - b;
        } else {
            result = b - a;
        }
        System.out.println("결과값:" + result);
    }

    static int mul(int a, int b) {
        int result = 0;
        result = a * b;
        return result;
    }

    static void div(int a, int b) {
        System.out.println("몫: " + a / b + ",  나머지: " + a % b);
    }

} // class
