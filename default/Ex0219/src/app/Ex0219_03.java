package app;

import java.util.Scanner;

/**
 * Ex0219_03 넓이 구하기 프로그램 1. 직사각형 2. 직삼각형 3. 마름모 4. 정사각형 5.원 while(true) ->
 * switch 1,2,3 -> 메소드로 분리하시오. 1. 2개 2. 2개 3. 1개 4. 2개
 */
public class Ex0219_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] areaArr = new int[3]; // 최대 3개까지 저장
        while (true) {
            System.out.println("[넓이 구하기 프로그램]");
            System.out.println("1) 직사각형 2) 직삼각형 3) 마름모 4) 정사각형 5) 원");
            switch (scan.nextInt()) {
                case 1:
                    printSetup("직사각형", areaArr, 2);
                    areaDefault(areaArr[0], areaArr[1]);
                    break;

                case 2:
                    printSetup("직삼각형", areaArr, 2);
                    areaDefault(areaArr[0], areaArr[1], 1);
                    break;

                case 3:
                    printSetup("마름모", areaArr, 2);
                    areaDefault(areaArr[0], areaArr[1], 2);
                    break;

                case 4:
                    printSetup("정사각형", areaArr, 2);
                    areaDefault(areaArr[0], areaArr[1]);
                    break;

                case 5:
                    printSetup("원", areaArr, 1);
                    areaCircle(areaArr[0]);
                    break;

                default:
                    System.out.println("잘못된 입력값");
                    break;
            }

        }
    } // main

    // 직사각형, 정사각형
    static void areaDefault(int a, int b) {
        System.out.println("넓이는 : " + a * b + " 입니다.");
    }

    // 직삼각형 , 마름모
    static void areaDefault(int a, int b, int option) {
        // 직삼각형
        if (option == 1) {
        }
        // 마름모
        else {
            System.out.println("한 대각선 * 다른 대각선 * 0.5");
        }
        System.out.println("넓이는 : " + a * b * 0.5 + "입니다.");
    }

    // 원
    static void areaCircle(int a) {
        double pi = 3.14;
        System.out.println("넓이는 : " + a * a * pi + "입니다.");
    }

    static void printSetup(String str, int[] arr, int option) {
        System.out.println(str + "의 넓이를 선택하셨습니다.");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < option; ++i) {
            System.out.println("{ " + (i + 1) + " 번째 값을 입력하세요. }");
            arr[i] = scan.nextInt();
        }
    }

} // class