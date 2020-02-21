package app;

/**
 * Ex0220_07
 */
public class Ex0220_07 {

    public static void main(String[] args) {
        // 1~25까지 랜덤으로 5개의 숫자를 배열에 넣고
        // 그 가운데 최대값을 구하시오.
        int[] five = new int[5];
        int[] twentyFive = new int[25];

        initArr(twentyFive);// 값 넣음
        shuffle(twentyFive); // 셔플
        assignArr(twentyFive, five); // 랜덤 5개 할당
        printArr(five);
        System.out.println("최댓값: " + (getMax(five))); // 최댓값 구하기

    } // main

    static void initArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i + 1;
        }
    }

    static void shuffle(int[] arr) {
        for (int i = 0; i < 10000; ++i) {
            int index = (int) (Math.random() * 25);
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
        }
    }

    static void assignArr(int[] twentyFive, int[] five) {
        for (int i = 0; i < five.length; ++i) {
            five[i] = twentyFive[i];
        }
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
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

} // class