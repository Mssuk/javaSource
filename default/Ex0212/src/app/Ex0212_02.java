package app;

import java.util.Scanner;

public class Ex0212_02 {

    public static void main(String[] args) {

        //영문 소문자를 받아서 대문자로 변환하는 프로그램

        
        char c;

        Scanner scan = new Scanner(System.in);
        System.out.println("소문자를 입력하면 대문자로 변환");
        c= scan.next().charAt(0);

        System.out.println((char)(c-32));



        // char[] hex ={'C', 'A', 'F', 'E'};
        // String[] binary = { "0000", "0001", "0010", "0011",
        //                             "0100", "0101", "0110", "0111",
        //                             "1000", "1001", "1010", "1011",
        //                             "1100", "1101", "1110", "1111",
        //                         };
        // String result="";

        // for(int i=0;i<hex.length; i++){
        //     if(hex[i]>='0' && hex[i]<='9') {
        //         result+= binary[hex[i]-'0']; //'8'-'0'의 결과는 8이다.
        //     } else { //A~F이면
        //         result+= binary[hex[i]-'A'+10]; //'C'-'A'의 결과는 2
        //     }
        // }



        // for(int i=0; i<hex.length; i++){
        //     if(hex[i]>='0' && hex[i]<='9') {
        //         result +=binary[hex[i]-'0'] + " ";
        //     } else {
        //         if(hex[i]>='A' && hex[i]<='Z') {
        //             hex[i] = (char)(hex[i]+32); //A->a, F->f
        //         }
        //         result += binary[hex[i]-'A'+10] + " "; //99-97+10 =12
        //     }
        // }


        // System.out.println("hex: "+new String(hex));
        // System.out.println("binary: " +result);
    }
}