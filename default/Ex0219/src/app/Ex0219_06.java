package app;

import java.util.Scanner;

/**
 * Ex0219_06
 */
public class Ex0219_06 {

    public static void main(String[] args) {

        /*
         * 1.학생점수 입력 2. 학생 수정 3.학생 삭제 4. 학생 검색 5. 등수처리 6.종료
         * 
         */

        Student[] stu = new Student[2];
        Scanner scan = new Scanner(System.in, "euc-kr");

        while (true) {
            System.out.println("----------------------------------------------------------------------");
            System.out.print("1.학생점수 입력\n2.학생 수정 \n3.학생 삭제 \n4.학생검색 \n5.등수처리 \n6.종료\n");
            int menu = scan.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("학생점수 입력");
                    String name = "";
                    int kor = 0, eng = 0, math = 0;

                    for (int i = 0; i < stu.length; ++i) {
                        System.out.println(i + 1 + " 번째 학생입니다.....");
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
                    break;

                case 2:
                    System.out.println("학생 수정입니다.");

                    for (Student student : stu) {
                        student.printInfo();
                    }
                    System.out.println("---------------------------------");
                    System.out.println("수정하고 싶은 학생의 이름을 입력하세요.");
                    String sname = scan.next();
                    String findName = "";
                    boolean updated = true;
                    loop3: for (int i = 0; i < stu.length; ++i) {
                        if (sname.equals(stu[i].name)) {
                            findName = stu[i].name;
                            System.out.println(findName + " 학생을 찾았습니다.");
                            System.out.println("1.국어점수 변경 2.영어점수 변경 3. 수학점수 변경");
                            switch (scan.nextInt()) {
                                case 1:
                                    System.out.println("새로운 국어점수를 넣으세요.");
                                    stu[i].kor = scan.nextInt();
                                    stu[i].updateTotalAvg();
                                    break loop3;

                                case 2:
                                    System.out.println("새로운 영어점수를 넣으세요.");
                                    stu[i].eng = scan.nextInt();
                                    stu[i].updateTotalAvg();
                                    break loop3;

                                case 3:
                                    System.out.println("새로운 수학점수를 넣으세요.");
                                    stu[i].math = scan.nextInt();
                                    stu[i].updateTotalAvg();
                                    break loop3;

                                default:
                                    System.out.println("잘못된 입력");
                                    updated = false;
                                    break loop3;
                            }
                        }
                    }
                    if (findName.isEmpty()) {
                        System.out.println("해당 학생이 없습니다.");
                    } else if (updated) {
                        System.out.println("수정이 완료 되었습니다.");
                        for (Student student : stu) {
                            student.printInfo();
                        }
                    }

                    break;

                case 3:
                    System.out.println("학생 삭제입니다.");
                    break;

                case 4:
                    System.out.println("학생 검색입니다.");
                    System.out.println("---------------------------------");
                    System.out.println("찾고 싶은 학생의 이름을 입력하세요.");
                    String sname4 = scan.next();
                    String findName4 = "";
                    for (int i = 0; i < stu.length; ++i) {
                        if (sname4.equals(stu[i].name)) {
                            findName4 = stu[i].name;
                            System.out.println(findName4 + " 학생을 찾았습니다.");
                            stu[i].printInfo();
                            break;
                        }
                    }
                    if (findName4.isEmpty()) {
                        System.out.println("해당 학생이 없습니다.");
                    }
                    break;

                case 5:
                    System.out.println("등수 처리입니다.");
                    break;

                case 6:
                    System.out.println("시스템을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 입력");
                    break;
            }
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