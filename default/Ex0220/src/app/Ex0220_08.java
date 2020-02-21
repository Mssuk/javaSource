package app;

/**
 * Ex0220_08
 */
public class Ex0220_08 {

    public static void main(String[] args) {
        // 1~100 까지 수를 사이즈 10 *10 배열에 넣어서
        // 오름차순으로 정렬.

        int[] hundred = new int[100];
        int[][] mat = new int[10][10];

        initNum(hundred); // 1~100까지 넣음
        shuffle(hundred); // 셔플
        setMat(hundred, mat); // 배열에 랜덤 숫자 집어넣음
        sortMat(mat); // 오름차순 정렬
        printMat(mat); // 출력

    }// main

    static void initNum(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i + 1;
        }
    }

    static void shuffle(int[] arr) {
        for (int i = 0; i < 1000; ++i) {
            int index = (int) (Math.random() * 100);
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
        }
    }

    static void setMat(int[] hundred, int[][] mat) {
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                mat[i][j] = hundred[i * mat[i].length + j];
            }
        }
    }

    // 행렬 정렬
    static void sortMat(int[][] mat) {
        for (int i = 0; i < mat.length; ++i) {
            sortArr(mat[i]);
        }
    }

    // 각 행 정렬
    static void sortArr(int[] arr) {
        // bubble sort
        for (int i = 0; i < arr.length; ++i) {
            boolean flag = false;
            for (int j = 1; j < arr.length - i; ++j) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    // print
    static void printMat(int[][] mat) {
        for (int[] is : mat) {
            for (int i : is) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}// class