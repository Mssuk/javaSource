package app;

import java.util.Scanner;

/**
 * Ex0213_03
 */
public class Ex0213_03 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        int[] num2 = new int[10];


        System.arraycopy(num, 2, num2, 5, 3);
        // //배열복사
        // for(int i=0; i<num.length; i++){
        //     num2[i] = num[i];
        // }

        for(int i=0; i<num.length; ++i){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        for(int i=0; i<num2.length; ++i){
            System.out.print(num2[i]+ " ");
        }


        // Scanner scan = new Scanner(System.in,"euc-kr");

        // while(true){
        //     for(int i=0; i<4; ++i){
        //         System.out.println("값을 입력하세요.>>");
        //         num[i] = scan.nextInt();

        //         System.out.println("입력값: "+num[i]);
        //     }
        // }


    }
}