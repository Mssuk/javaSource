package app;

import java.util.Scanner;

/**
 * Ex0213_05
 */
public class Ex0213_05 {

    public static void main(String[] args) {
        // 학생성적처리 프로그램
        // 1.학생점수 추가 2. 학생점수 수정 3. 학생점수 삭제 4. 종료
        // 1-> 국어 점수 입력

        // 1. 국어 2. 영어 3. 합계

        Scanner scan = new Scanner(System.in, "euc-kr");

        System.out.println("몇명 입력하시겠습니까?");
        int people = scan.nextInt();

        String[] name = new String[people]; // 이름
        int[][] score = new int[people][4]; // 점수
        double[] avg = new double[people]; // 평균
        int[] rank = new int[people];
        int rank_count = 1; // 등수카운트

        String subject[] = { "이름", "국어", "영어", "수학", "합계", "평균", "등수" };

        // 이름,점수 입력
        for (int i = 0; i < score.length; i++) {
            System.out.println("이름을 입력하세요>>");
            name[i] = scan.next();
            // name[i].trim();
            for (int j = 0; j < score[i].length - 1; j++) {
                System.out.println((i + 1) + " 번째 " + subject[j + 1] + " 점수를 입력하세요>>");
                score[i][j] = scan.nextInt();
                // 유효성 검사
                if (score[i][j] < 1 || score[i][j] > 100) {
                    System.out.println("1점~100점 사이의 점수만 입력해야합니다.");
                    j--;
                    continue;
                }

                score[i][score[i].length - 1] = score[i][score[i].length - 1] + score[i][j];
                // 합계 = 합계 + 추가점수
            }
            // 평균
            avg[i] = (double) score[i][score[i].length - 1] / 3.0;
        }

        //등수 구하기
        for (int i = 0; i < score.length; ++i) {
            rank_count = 1;
            for (int j = 0; j < score.length; ++j) {
                if (score[i][score[i].length - 1] < score[j][score[i].length - 1]) {
                    rank_count++;
                }
            }
            rank[i] = rank_count;
        }

        // 제목 출력
        for (int i = 0; i < subject.length; i++) {
            System.out.print(subject[i] + "\t");
        }
        System.out.println();

        // 이름,점수,평균 출력
        for (int i = 0; i < score.length; ++i) {
            System.out.print(name[i] + "\t");
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "\t");
            }
            System.out.printf("%.1f", avg[i]);
            System.out.print("\t" + rank[i]);
            System.out.println();
        }

    }

}