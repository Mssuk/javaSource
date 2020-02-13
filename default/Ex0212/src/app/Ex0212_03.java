package app;

import java.util.Scanner;

/**
 * Ex0212_03
 */
public class Ex0212_03 {
    public static void main(String[] args) {       
        // 배열 12개
        String[] ganji = {"쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양", "원숭이", "닭", "개", "돼지"};
        String[] hanmun = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};

        //갑을병정무기경신임계 자축인묘진사오미신유술해

        Scanner scan = new Scanner(System.in);
        int select = 0;
        String word="";

        while (true) {


            try{
                
            System.out.println("1~12번까지 숫자를 입력하세요. (간지 입력하면 간지변환기도 가능)");
            select = scan.nextInt();
            System.out.println(select + " 번째의 띠는 ? " + ganji[select - 1]+ "("+ hanmun[select-1] +")");
            } catch(Exception e){
                
                System.out.println("간지 변환기");
                word = scan.next();
                
                System.out.println(word);
                for(int i=0; i<ganji.length; ++i){
                    if(word.equals(ganji[i])){
                        System.out.println(word+"는 "+hanmun[i]);
                    }
                    else if(word.equals(hanmun[i])) {
                        System.out.println(word+"는 "+ganji[i]);
                    }
                }



            }
            



        }
    }
}