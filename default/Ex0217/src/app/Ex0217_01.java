package app;

import java.util.Scanner;

/**
 * Ex0217_01 3. 성적처리 프로그램 (기본- 이름,국어,영어,수학,합계,평균, 등수) (옵션 -1 .학생추가 2.학생출력 3.
 * 등수처리 0.종료)
 */
public class Ex0217_01 {

    public static void main(String[] args) {

        String[] subject = { "이름", "국어", "영어", "수학", "합계", "평균", "등수" };
        int menu = 0; // 메뉴 누르면 입력받는 변수

        int people = 5; // 5명까지
        String[] name = new String[people];
        int[][] score = new int[people][4];
        double[] avg = new double[people];
        int[] rank = new int[people];
        int save = 0;// 세이브 지점
        int rank_count = 1; // 랭크 카운트
        int init = 1; // 처음 입력값인지 아닌지 판단하기 위한 변수(6번째 학생이 들어오면 1번째 학생 데이터 덮어씀)

        Scanner scan = new Scanner(System.in, "euc-kr");
        while (true) {
            System.out.println("1)학생추가 2)학생출력 3)등수처리 0) 종료");
            menu = scan.nextInt();

            if (menu == 1) {
                System.out.println("학생 추가 선택하셨습니다.");
                System.out.println("최대 5명까지 입력할 수 있습니다.");
                for (int i = 0; i < people; ++i) {

                    // 세이브 지점이 있으면 i를 변겅
                    if (save != 0) {
                        i = save;
                        save = 0;
                    }

                    System.out.println(i + 1 + "번째 학생의 이름을 입력하세요. ( 0)이전으로 )");
                    String inputs = "";
                    inputs = scan.next();

                    // if input == 0
                    if (inputs.equals("0")) {
                        System.out.println("이전으로 돌아갑니다.");
                        save = i; // save 해줌
                        break;
                    }
                    name[i] = inputs;

                    for (int j = 0; j < score[i].length - 1; ++j) {
                        System.out.println(name[i] + " 학생의 " + subject[j + 1] + "점수를 입력하세요.");
                        score[i][j] = scan.nextInt();
                        if (score[i][j] < 0 || score[i][j] > 100) {
                            System.out.println("점수는 0~100점까지 입니다.");
                            j--;
                            continue;
                        }

                        // sum
                        // 6번째 학생부터는 기존값 초기화
                        if (init != 1 && j == 0) {
                            score[i][score[i].length - 1] = 0;
                            rank[i] = 0;
                        }
                        score[i][score[i].length - 1] += score[i][j];
                    }
                    // avg
                    avg[i] = score[i][score[i].length - 1] / 3.0; // 3과목
                }
                init++;
                continue;

            } else if (menu == 2) {
                System.out.println("학생의 성적을 출력합니다.");

                // subject
                for (int i = 0; i < subject.length; ++i) {
                    System.out.print(subject[i] + "\t");
                }
                System.out.println();
                for (int i = 0; i < score.length; ++i) {
                    // name
                    if (name[i] == null) {
                        break;
                    } // null이면 출력을 멈춘다.
                    System.out.print(name[i] + "\t");
                    for (int j = 0; j < score[i].length; ++j) {
                        System.out.print(score[i][j] + "\t");
                    }
                    System.out.printf("%.1f\t", avg[i]); // avg
                    System.out.println(rank[i] != 0 ? rank[i] : "계산안됨"); // rank
                }

            } else if (menu == 3) {
                System.out.println("등수를 계산합니다.");
                for (int i = 0; i < name.length; ++i) {
                    rank_count = 1;
                    for (int j = 0; j < name.length; ++j) {
                        if (score[i][score[i].length - 1] < score[j][score[j].length - 1]) {
                            rank_count++;
                        }
                    }
                    rank[i] = rank_count;
                }
                System.out.println("계산 완료");

            } else if (menu == 0) {
                System.out.println("시스템을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력");
            }

        }

    }
}