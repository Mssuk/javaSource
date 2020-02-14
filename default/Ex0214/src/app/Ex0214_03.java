package app;

import java.util.Scanner;

/**
 * Ex0214_03
 */
public class Ex0214_03 {

    public static void main(String[] args) {
        // 영어 단어 맞추기 게임
        // 영어 - 한글설명
        // 1.영어, 한글 데이터 입력- 미리 입력 만듦.
        // 2.영어 출력후 한글 입력 받음
        // 3.한글이 맞는지 확인
        // 4.결과 출력
        // 5.다시 문제 출력

        // 문제를 5개 입력받아서
        // 문제를 풀어보세요.

        // 데이터 입력 words[3][2]
        // String[][] words = { { "chair", "의자" }, { "computer", "컴퓨터" }, { "array",
        // "배열" }, };
        String[][] words = new String[10][2];
        String inStr = "";
        Scanner scan = new Scanner(System.in, "euc-kr");
        int answerCnt = 1; // 시도횟수 카운트
        int menu = 0; // 메뉴 카운트
        int save = 0; //인덱스 세이브

        System.out.println("[퀴즈 프로그램]");
        while (true) {
            System.out.print("1) 문제 입력.. 2) 문제 풀이.. 0) 프로그램 종료...");
            menu = scan.nextInt();

            if (menu == 1) {
                System.out.println("[문제 입력기... 최대 10번]");
                for (int i = 0; i < words.length; ++i) {

                    System.out.println((i + 1) + "번째 문제입니다.. 영어를 입력하세요. (0) 이전화면");
                    words[i][0] = scan.next();
                    if (words[i][0].equals("0")) {
                        break;
                    }
                    System.out.println("한글을 입력하세요.");
                    words[i][1] = scan.next();
                    if(i == words.length-1){
                        System.out.println(words.length+"개가 모두 입력되었습니다.");
                    }
                }
            } else if (menu == 2) {
                scan.nextLine();
                if (words[0][1] == null) {
                    System.out.println("문제를 1개 이상 입력해야합니다.");
                    continue;
                }
                System.out.println("문제를 풀어보세요.");
      
                for (int i = 0; i < words.length; ++i) {
                    
                    //풀이 시작지점 불러오기
                    if(save != 0){
                        i = save;
                    }    
                    if (i != 0 && i != words.length - 1) {
                        System.out.println("다음 문제 도전!");
                    }
                    if (answerCnt > 3) {
                        System.out.println("XXXXXXXXXXX 정답은 " + words[i][1]);
                        i++;
                        answerCnt = 1;
                    }
                    if (i >= words.length || words[i][1] == null) {
                        break;
                    }
                    System.out.println(words[i][0] + " 뜻은 무엇일까요? 3번까지 입력가능 (이전화면:99)");
                    inStr = scan.nextLine();
                    if(inStr.equals("99")){
                        System.out.println("이전화면으로 이동합니다.");
                        save = i;
                        break;
                    }
                    //정답 비교
                    if (words[i][1].equals(inStr)) {
                        System.out.print("정답입니다.");
                        answerCnt = 1;
                    } else {
                        System.out.println(answerCnt + " 번째 오답입니다.");
                        i--;
                        answerCnt++;
                    }
                }

            } else if (menu == 0) {
                System.out.println("~~~~프로그램 종료~~~~~");
                break;
            } else {
                System.out.println("잘못된 입력 값");
            }

        }

    }
}