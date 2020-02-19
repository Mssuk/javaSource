package app;

import java.util.Scanner;

/**
 * Ex0213_02
 */
public class Ex0213_02 {

    //16진수 ->2진수

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in,"euc-kr");

        char[] hex = new char[10]; //입력받은 문자를 대입
        String str=""; //입력받은 문자열
        System.out.println("10개 이하로 문자를 입력하세요.(ABCDEF)>>");
        str = scan.next(); //입력값 ABC 
        for(int i=0; i<str.length(); i++) {
            hex[i] = str.charAt(i); //0-> A ,1->B , 2->C
        }

        String[] binary = {
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111",
        };

        String result ="";

        for(int i=0; i<str.length(); i++){
            if(hex[i]>='0' && hex[i]<='9'){
                result =result+binary[hex[i]-'0']+ " ";
            } else {
                result= result + binary[(hex[i]-'A')+10]+ " ";
            }
        }
        for(int i=0; i<str.length(); i++) {
            System.out.print(hex[i]+" ");
        }
        System.out.println();
        System.out.println(result);

    }
    
        

}