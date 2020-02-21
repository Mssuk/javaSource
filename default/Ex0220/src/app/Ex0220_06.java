package app;

import java.util.Scanner;

/**
 * Ex0220_06
 * 
 * 
 * 각 줄로 최대값 구해서 출력
 * 
 */
public class Ex0220_06 {

    public static void main(String[] args) {
        // 1~25까지의 숫자를 5개짜리 배열에 랜덤으로 넣어보시오.
        int[] twentyFive = new int[25];
        int[] five = new int[5];
        int[][] lotto = new int[2][5]; // 값 10개를 넣어보시오.

        // Bingo
        int[][] lotto2 = new int[5][5];
        String xy = "";
        int x = 0;
        int y = 0;
        Scanner scan = new Scanner(System.in);

        inArr(twentyFive); // 값넣기
        shuffleArr(twentyFive); // 값 섞기
        sixArr(twentyFive, five); // 6개에 넣기

        // 2중 for문에 넣기
        sixArr(lotto, twentyFive); // 값넣기
        shuffleArr(twentyFive); // 값섞기
        printLotto(lotto); // 10개에 값넣기

        sixArr(lotto2, twentyFive);
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        while (true) {

            printLotto(lotto2);
            System.out.println("--------------------------------------");
            System.out.println("원하는 번호를 입력하세요.(x,y) -> (0,0)");
            xy = scan.nextLine(); // 15-> 1,5
            x = xy.charAt(0) - '0';
            y = xy.charAt(1) - '0';
            if (lotto2[x][y] != 0) {
                lotto2[x][y] = 0;
            } else {
                System.out.println("이미 선택했습니다.");
            }

        }

    }// main

    static void printLotto(int[][] lotto) {
        int j = 0;
        System.out.print("\t" + "0" + "\t" + "1" + "\t" + "2" + "\t" + "3" + "\t" + "4" + "\t" + "\n");
        System.out.println("-----------------------------------------");
        for (int[] is : lotto) {
            System.out.print(j + "\t");
            j++;
            for (int i : is) {
                System.out.print(i + "\t");
            }
            if (j == 1) {
                System.out.print("첫째줄의 최댓값: " + getMax(lotto[0]));
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    static int getMax(int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    static void inArr(int[] lotto) {
        for (int i = 0; i < lotto.length; ++i) {
            lotto[i] = i + 1;
        }
    }

    static void shuffleArr(int[] twentyFive) {
        for (int i = 0; i < 10000; ++i) {
            int index = (int) (Math.random() * 25);
            int temp = twentyFive[0];
            twentyFive[0] = twentyFive[index];
            twentyFive[index] = temp;
        }

    }

    static void sixArr(int[][] lotto, int[] twentyFive) {

        for (int i = 0; i < lotto.length; ++i) {
            for (int j = 0; j < lotto[i].length; ++j) {
                // lotto[i][j] = (i* lotto[i].length) + j+ 1;
                lotto[i][j] = twentyFive[i * lotto[i].length + j];
            }
        }

    }

    static void sixArr(int[] twentyFive, int[] five) {

        System.arraycopy(twentyFive, 0, five, 0, five.length);
    }
}// class