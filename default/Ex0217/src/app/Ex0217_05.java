package app;

import java.util.Scanner;

/**
 * Ex0217_05
 */

class MadeBoard {

    String[] subjects = { "번호", "제목", "내용", "작성자", "조회수" };
    Board[] bd;

    public MadeBoard(int count){
            bd  = new Board[count];
    }

    void printSubjects() {
        for (int i = 0; i < subjects.length; ++i) {
            System.out.print(subjects[i] + "\t");
            if (subjects[i].equals("내용")) {
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    void printAllBoard() {
        for (int j = 0; j < bd.length; ++j) {
            if (bd[j] != null)
                bd[j].printBoard();
        }
    }
}

public class Ex0217_05 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in, "euc-kr");
        int num = 5; // 5개

        MadeBoard nB = new MadeBoard(num);

        System.out.println("[게시판 프로그램]");
        for (int i = 0; i < num; ++i) {
            nB.bd[i] = new Board();
            nB.bd[i].no = i + 1; // 글 번호 자동매김
            System.out.println("글 제목을 입력하세요");
            nB.bd[i].sub = scan.nextLine();
            System.out.println("글 내용을 입력하세요");
            nB.bd[i].cont = scan.nextLine();
            System.out.println("작성자를 입력하세요");
            nB.bd[i].writer = scan.nextLine();

            nB.printSubjects();
            nB.printAllBoard();
            System.out.println();
        }

    }

}