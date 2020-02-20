package app;

import java.util.Scanner;

/**
 * Ex0220_05
 */
public class Ex0220_05 {

    public static void main(String[] args) {
        // 로또 1~45까지의 6개의 값을
        // lotto2 배열에 넣어보세요.

        int[] lotto = new int[45];
        int[] lotto2 = new int[6];
        int num = 0;
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < lotto.length; ++i) {
            lotto[i] = i + 1;
        }
        shuffle(lotto, lotto2);

        // for (int i = 0; i < 6; ++i) {
        // lotto2[i] = lotto[i];
        // }

        while (true) {
            System.out.println("숫자를 입력하세요.");
            System.out.println("1. 배열출력하기");
            System.out.println("2. 배열섞기");
            System.out.println("3. 배열의합구하기");
            System.out.println("4. 배열정렬");
            num = scan.nextInt();
            switch (num) {

                case 1:
                    System.out.println("6개의 배열을 출력합니다.");
                    printArr(lotto2);
                    break;

                case 2:
                    System.out.println("다시 섞습니다.");
                    shuffle(lotto, lotto2);
                    break;
                case 3:
                    System.out.println("6개의 합");
                    int sum = 0;
                    sum = sumArr(lotto2);
                    System.out.println(sum);
                    break;
                case 4:
                    System.out.println("배열 정렬");
                    sortArr(lotto2);
                    break;
                default:
                    break;
            } // switch
        } // while

    } // main

    static void printArr(int[] lt) {
        for (int i : lt) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void shuffle(int[] lotto, int[] lotto2) {
        for (int i = 0; i < 6; ++i) {
            int index = (int) (Math.random() * 45); // 0~44
            int temp = lotto[i];
            lotto[i] = lotto[index];
            lotto[index] = temp;
        }
        System.arraycopy(lotto, 0, lotto2, 0, 6);
    }

    static int sumArr(int[] arr){
        int result = 0;
        for(int i=0; i<arr.length; ++i){
            result+=arr[i];
        }
        return result;
    }

    static void sortArr(int[] arr){

        //bubble sort
        for(int i=0; i<arr.length; ++i){
            boolean change =false;
            for(int j=1; j<arr.length-i; ++j){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    change = true;
                }
            }
            if(change == false){
                break;
            }
        }


        // //selection sort
        // int indexMin, temp;
        // for(int i=0; i<arr.length; ++i){
        //     indexMin = i;
        //     for(int j =i+1; j<arr.length; ++j){
        //         if(arr[j]<arr[indexMin]){
        //             indexMin = j;
        //         }
        //     }
        //     temp = arr[indexMin];
        //     arr[indexMin] = arr[i];
        //     arr[i] = temp;
        // }

        // //insertion sort
        // for(int i=1; i<arr.length; i++){
        //     int temp = arr[i];
        //     int aux = i- 1;

        //     while((aux>=0) && (arr[aux]>temp) ){
        //         arr[aux+1] = arr[aux];
        //         aux--;
        //     }
        //     arr[aux+1]= temp;
        // }

    }
} // class