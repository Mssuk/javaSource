package app;

import java.util.Scanner;

/**
 * Ex0213_06 1. 이름 입력 2. 국어, 영어 3. 합계 계산 4. 평균 계산 5. 등수 계산
 * 
 * 
 */
public class Ex0213_06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "euc-kr");
        String[] subject = { "이름", "국어", "영어", "합계", "평균", "등수" };
        String name[] = new String[3]; // 3명
        int score[][] = new int[name.length][3]; // 점수, ; 2과목.
        double avg[] = new double[name.length]; // 평균
        int rank[] = new int[name.length]; // 등수
        int rank_count = 1; // rank count

        for (int i = 0; i < score.length; ++i) {
            System.out.println("학생의 이름은 무엇인가요?");
            name[i] = scan.next();
            for (int j = 0; j < score[i].length - 1; ++j) {
                System.out.println(name[i] + " 학생의 " + subject[j + 1] + " 과목점수를 입력하시오.");
                score[i][j] = scan.nextInt();
                if(score[i][j]<1 || score[i][j]>100) {
                    System.out.println("점수는 1점~100점 사이입니다.");
                    j--;
                    continue;
                }

                // 합계
                score[i][score[i].length - 1] += score[i][j];
            }
            avg[i] = score[i][score[i].length - 1] / 2.0; // 2과목임
        }

        // rank 구하기
        for (int i = 0; i < score.length; ++i) {
            rank_count = 1;
            for (int j = 0; j < score.length; ++j) {
                if (score[i][score[i].length - 1] < score[j][score[j].length - 1]) {
                    rank_count++;
                }
            }
            rank[i] = rank_count;
        }

        for (int i = 0; i < subject.length; ++i) {
            System.out.print(subject[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < score.length; ++i) {
            System.out.print(name[i] + "\t");
            for (int j = 0; j < score[i].length; ++j) {
                System.out.print(score[i][j] + "\t");
            }
            System.out.printf("%.1f", avg[i]);
            System.out.print("\t" + rank[i]);
            System.out.println();
        }

    }
}