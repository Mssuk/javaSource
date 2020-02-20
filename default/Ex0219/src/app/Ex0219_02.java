package app;

import java.util.Scanner;

/**
 * Ex0219_02
 */
public class Ex0219_02 {

    public static void main(String[] args) {
        // 1. 최대값 구하기 (3개의 숫자를 넣어서 1.최대값과 2.최대값이 얼마인지 최소값이 얼마인지를 알아내는 형태)
        // 2. 절대값 구하기(1개의 숫자를 넣어서 절대값을 구하는 것)
        // 3. 제곱값 구하기 (첫번째 숫자 5, 제곱 숫자 2)
        // 1,2 원하는 번호를 입력하세요>>
        Scanner scan = new Scanner(System.in);

        loop1: while (true) {

            print(); // 화면 출력 메소드

            switch (scan.nextInt()) {
                case 1:

                    showMax();
                    break;

                case 2:
                    showAbs();
                    break;

                case 3:
                    showPow();
                    break;

                default:
                    System.out.println("잘못된 입력");
                    break;
            }
        }

    } // main

    static void print() {

        System.out.println("---------------------------");
        System.out.println("[ 수학공식 프로그램] ");
        System.out.println("---------------------------");
        System.out.println("1. 최대값 구하기 2. 절대값 구하기 3. 제곱값 구하기");
        System.out.println("원하는 번호를 입력하세요...");

    }

    static void showMax() {

        Scanner scan = new Scanner(System.in);
        // 최대값 무한 반복
        while (true) {

            System.out.println("최대값 구하기..");
            int[] arr = new int[3];
            for_int(arr);
            if (arr[0] == 99) {
                break;
            } else if (arr[0] == 0) {
                System.exit(0);
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // Math.max( )를 써도 된다.
            // Math.max(Math.max(arr[0], arr[1]), arr[2])
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.println("최대값은 : " + max + " 최소값은 : " + min);
        }

    }

    static void showAbs() {
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("절대값 구하기..");
            System.out.println("값을 입력하세요 ( 99: 이전화면 0: 종료)");
            int selectNum = scan.nextInt();
            if (selectNum == 99) {
                break;
            } else if (selectNum == 0) {
                System.exit(0);
            }
            int result = 0;
            if (selectNum < 0) {
                result = selectNum * -1;
            } else {
                result = selectNum;
            }
            System.out.println("절대값은 : " + result);
        }
    }

    static void showPow() {
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("제곱값 구하기..");
            System.out.println("밑을 입력하세요 ( 99: 이전화면 0: 종료)");
            int mit = scan.nextInt();
            if (mit == 99) {
                break;
            } else if (mit == 0) {
                break;
            }
            System.out.println("지수를 입력하세요");
            int we = scan.nextInt();

            System.out.println((int) Math.pow(mit, we));
        }
    }

    static int[] for_int(int[] arr) {

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("숫자를 입력하세요. (이전화면: 99)>>>");
            arr[i] = scan.nextInt();
            if (arr[i] == 99) {
                break;
            } else if (arr[i] == 0) {
                System.exit(0);
            }
        }
        return arr;
    }

} // calss