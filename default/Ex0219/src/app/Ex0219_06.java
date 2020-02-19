package app;

import java.util.Scanner;

/**
 * Ex0219_06
 */
public class Ex0219_06 {

    public static void main(String[] args) {

        Student[] stu = new Student[2];
        Scanner scan = new Scanner(System.in, "euc-kr");
        String name = "";
        int kor = 0, eng = 0, math = 0;

        for (int i = 0; i < stu.length; ++i) {
            System.out.println("이름을 넣으세요.");
            name = scan.next();
            System.out.println("국어점수를 넣으세요.");
            kor = scan.nextInt();
            System.out.println("영어점수를 넣으세요.");
            eng = scan.nextInt();
            System.out.println("수학점수를 넣으세요.");
            math = scan.nextInt();
            stu[i] = new Student(name, kor, eng, math);
        }

        for (Student student : stu) {
            student.printInfo();
        }

        // Lotto[] l = new Lotto[45];
        // for(int i=0; i<l.length ; i++){
        // l[i] = new Lotto(i+1);
        // }

        //////////////////////////////////////////////////////////////////////////////////////

        // Card 13장의 배열을 만들어서
        // 1~13까지 클로버
        // 만들어보세요.

        // String[] kind = {"클로버", "다이아몬드", "스페이드", "하트"};
        // Card[] deck = new Card[52];

        // for (int i = 0; i < 4; ++i) {
        // for(int j=0; j<13; j++){
        // //deck[(i*13)+j] = new Card(j+1, kind[i]);
        // deck[(i*13)+j] = new Card();
        // deck[(i*13)+j].number = j+1;
        // deck[(i*13)+j].kind = kind[i];
        // System.out.print( deck[(i*13)+j].kind + " " + deck[(i*13)+j].number + "\n");
        // }

        // }

        /////////////////////////////////////////////////////////////////////
        // Card c1 = new Card(10, "클로버");
        // Card c2 = new Card();

        // // Card c1 = new Card();
        // // c1.number = 10;
        // // c1.kind= "클로버";
        // System.out.println(c1.number + " "+ c1.kind);
    }
}