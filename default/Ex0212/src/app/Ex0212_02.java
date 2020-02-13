package app;

import java.util.Scanner;

public class Ex0212_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            String result = "";
            char ch;
            System.out.println("문자를 입력하세요.>>");
            String in_str = scan.next();

            for (int i = 0; i < in_str.length(); i++) {
                ch = in_str.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    result = result + (char) (ch - 32) + "";
                } else {
                    result = result + (char) (ch + 32) + "";
                }
            }

            System.out.println("결과값: " + result);
        }

        // String str;

        // //소문자는 대문자로 대문자는 소문자로 바꾸는 프로그램

        // System.out.println("변환할 문자열을 입력하세요.");
        // str = scan.next();
        // char[] chArr = new char[str.length()];

        // for(int i=0; i<chArr.length; ++i){

        // char temp = str.charAt(i);
        // if(temp>='a' && temp<='z'){
        // chArr[i] = (char)(temp -32);
        // } else if(temp>='A' && temp<='Z'){
        // chArr[i] = (char)(temp+32);
        // }
        // }

        // System.out.println("변환 결과는");
        // for (char c : chArr) {
        // System.out.print(c);
        // }
        // System.out.println();

        // 영문 소문자를 받아서 대문자로 변환하는 프로그램
        // while (true) {
        // System.out.println("변환");
        // System.out.println("------");
        // //c = scan.next().charAt(0);

        // // if (c >= 'a' && c <= 'z') {
        // // c = (char) (c - 32);
        // // } else {
        // // c = (char) (c + 32);
        // // }
        // //System.out.println(c);
        // String str = scan.next();

        // System.out.println("대문자 치환");
        // System.out.println(str.toUpperCase());

        // System.out.println("소문자 치환");
        // System.out.println(str.toLowerCase());
        // }

        // char[] hex ={'C', 'A', 'F', 'E'};
        // String[] binary = { "0000", "0001", "0010", "0011",
        // "0100", "0101", "0110", "0111",
        // "1000", "1001", "1010", "1011",
        // "1100", "1101", "1110", "1111",
        // };
        // String result="";

        // for(int i=0;i<hex.length; i++){
        // if(hex[i]>='0' && hex[i]<='9') {
        // result+= binary[hex[i]-'0']; //'8'-'0'의 결과는 8이다.
        // } else { //A~F이면
        // result+= binary[hex[i]-'A'+10]; //'C'-'A'의 결과는 2
        // }
        // }

        // for(int i=0; i<hex.length; i++){
        // if(hex[i]>='0' && hex[i]<='9') {
        // result +=binary[hex[i]-'0'] + " ";
        // } else {
        // if(hex[i]>='A' && hex[i]<='Z') {
        // hex[i] = (char)(hex[i]+32); //A->a, F->f
        // }
        // result += binary[hex[i]-'A'+10] + " "; //99-97+10 =12
        // }
        // }

        // System.out.println("hex: "+new String(hex));
        // System.out.println("binary: " +result);
    }
}