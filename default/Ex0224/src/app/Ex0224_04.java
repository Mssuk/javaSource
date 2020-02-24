package app;

import java.util.Scanner;

/**
 * Ex0224_04
 */
public class Ex0224_04 {

    static String[] subject = { "학번", "이름", "국어", "영어", "수학", "합계", "평균", "등수" };
    static Scanner sc = new Scanner(System.in, "euc-kr");
    static int save = 0; // save point
    final static int STUNUM = 3; // 학생 수

    public static void main(String[] args) {

        // 3명의 학생을 입력받아서 학번, 이름, 국어, 영어, 수학, 합계 ,평균, 등수
        // 학번은 1에서 1씩 증가. - 자동입력 되도록.
        // 입력부분은 메소드로 분리.
        // 출력부분 메소드로 분리.
        // 등수출력 메소드로 분리.
        // 성적수정 메소드로 분리
        /*
         * 1.학생성적입력 2.학생성적출력 3.학생성적수정 4.학생등수입력 5.종료
         */

        /////////////////////////////////////////////////////////////////////////////

        Student[] stu = new Student[STUNUM]; // 3명
        int[] score = new int[3]; // 점수 받는 배열
        int menu = 0;// 메뉴 입력 변수

        //////////////////////////////////////////////////////////

        while (true) {

            printMenu();
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    input(stu, score);
                    break;

                case 2:
                    printScore(stu);
                    break;
                case 3:
                    alter(stu);
                    break;
                case 4:
                    rankCal(stu);
                    break;
                case 5:
                    System.out.println("시스템을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력 값");
                    break;
            }
        }

    }// main

    static void printMenu() {
        System.out.println("-------------------------------");
        System.out.print("1.학생성적입력\n2.학생성적출력\n3.학생성적수정\n4.학생등수입력\n5.종료\n");
        System.out.println("-------------------------------");
    }

    static void input(Student[] stu, int[] score) {
        System.out.println("[학생 성적 입력]");
        for (int i = 0; i < stu.length; ++i) {
            if (save != 0) {
                i = save;
                save = 0;
            }
            String name;
            System.out.println(i + 1 + " 번째 학생의 이름을 입력하세요.>>> 0) 상위메뉴");
            name = sc.next();
            if (name.equals("0")) {
                save = i;
                return;
            }
            for (int j = 0; j < score.length; ++j) {
                System.out.println(j + 1 + " 번째 점수를 입력하세요.>>>");
                score[j] = sc.nextInt();
                if (score[j] < 0 || score[j] > 100) {
                    System.out.println("점수는 0~100점까지의 범위입니다.");
                    j--;
                }
            }
            stu[i] = new Student(name, score[0], score[1], score[2]);
            stu[i].modify();
        }

    }

    static void printScore(Student[] stu) {
        System.out.println("[학생 성적 출력]");
        for (int i = 0; i < subject.length; ++i) {
            System.out.print(subject[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < stu.length; ++i) {
            if (stu[i] != null) {
                System.out.print(stu[i]);
                System.out.print(stu[i].rank == 0 ? "\t계산안됨\n" : "\t" + stu[i].rank + "\n");
            }
        }
        System.out.println();
    }

    static void rankCal(Student[] stu) {
        if (stu[0] == null) {
            System.out.println("입력된 학생이 없습니다.");
            return;
        }
        System.out.println("[등수를 계산합니다]");
        int rank_count = 1;
        for (int i = 0; i < stu.length; ++i) {
            if (stu[i] == null) {
                continue;
            }
            rank_count = 1;
            for (int j = 0; j < stu.length; ++j) {
                if (stu[j] == null) {
                    continue;
                }
                if (stu[i].total < stu[j].total) {
                    rank_count++;
                }
            }
            stu[i].rank = rank_count;
        }
        System.out.println("[등수 입력 완료]");
        printScore(stu);
    }

    static void alter(Student[] stu) {
        while (true) {

            if (stu[0] == null) {
                System.out.println("입력된 학생이 없습니다.");
                return;
            }
            System.out.println("[학생 성적 수정] ");
            System.out.println("수정하고 싶은 학생의 이름을 입력하세요. 0) 상위메뉴");
            String sname = sc.next();

            if (sname.equals("0")) {
                return;
            }

            boolean isFind = false;
            Student fs = null;
            for (int i = 0; i < stu.length; ++i) {
                if (stu[i] != null && sname.equals(stu[i].name)) {
                    System.out.println(stu[i].name + " 학생을 찾았습니다.");
                    isFind = true;
                    fs = stu[i];
                    break;
                }
            }

            if (isFind) {
                while (true) {
                    System.out.println("수정하고 싶은 과목을 입력하세요.");
                    System.out.println("1) 국어 점수 2) 영어 점수 3) 수학 점수 4) 이름 수정 0) 상위 메뉴");
                    int selected = sc.nextInt();
                    int newScore = 0;
                    if (selected < 0 || selected > 4) {
                        System.out.println("잘못된 입력 값");
                        continue;
                    }
                    if (selected == 0) {
                        fs.modify();
                        break;
                    }

                    if (selected == 4) {
                        System.out.println("새로운 이름은?");
                        fs.name = sc.next();
                        break;
                    }
                    System.out.println("새로운 점수는?");
                    newScore = sc.nextInt();
                    if (selected == 1) {
                        System.out.print("기존 국어 점수 : " + fs.kor);
                        fs.kor = newScore;
                    } else if (selected == 2) {
                        System.out.print("기존 영어 점수 : " + fs.kor);
                        fs.eng = newScore;
                    } else if (selected == 3) {
                        System.out.print("기존 수학 점수 : " + fs.kor);
                        fs.math = newScore;
                    }
                    System.out.println(" , 변경된 점수 : " + newScore);
                    System.out.println("[점수 변경 완료]");
                }

            } else {
                System.out.println("해당 학생이 없습니다.");

            }
        }

    }

}// class