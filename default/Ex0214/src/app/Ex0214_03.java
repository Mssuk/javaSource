package app;

import java.util.Scanner;

/**
 * Ex0214_03
 */
public class Ex0214_03 {

    public static void main(String[] args) {
        //영어 단어 맞추기 게임
        //영어 - 한글설명
        //1.영어, 한글 데이터 입력- 미리 입력 만듦.
        //2.영어 출력후 한글 입력 받음
        //3.한글이 맞는지 확인
        //4.결과 출력
        //5.다시 문제 출력

        //데이터 입력 words[3][2]
        String[][] words = { {"chair","의자"}, {"computer","컴퓨터"}, {"array","배열"}, };

        String inStr="";
        Scanner scan = new Scanner(System.in, "euc-kr");
        int answerCnt = 1; //시도횟수 카운트

        for(int i=0; i<words.length; ++i)
        {
            if(answerCnt>3){
                System.out.println("XXXXXXXXXXX 정답은 "+ words[i][1]);
                i++;
                answerCnt = 1;
            }
            System.out.println(words[i][0]+ " 뜻은 무엇일까요? 3번까지 입력가능");
            inStr = scan.nextLine();
            if(words[i][1].equals(inStr)){
                System.out.println("정답입니다. 다음 문제 도전!");
                answerCnt = 1;
            } else {
                System.out.println("오답입니다.");
                i--;
                answerCnt++;
            }

        }
    }
}