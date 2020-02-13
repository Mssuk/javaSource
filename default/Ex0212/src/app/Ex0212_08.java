package app;

import java.util.Scanner;

/**
 * Ex0212_08
 */
public class Ex0212_08 {

    public static void main(String[] args) {
        
        //성적처리 프로그램
        //이름(string), 국어, 영어, 수학, 합계(int), 평균(double)
        String[] name = new String[3];
        int[][] score = new int[3][4];
        //[0,0] [0,1] [0,2] - 점수 [0,3]- 합계
        double[] avg = new double[3];
        String[] subject = {"이름", "국어", "영어", "수학", "합계", "평균"};

        Scanner scan = new Scanner(System.in);
        
        //score array 입력폼
        for(int i=0; i<score.length; i++) {
            //이름 입력
            System.out.println((i+1)+ "번 학생의 이름을 입력해주세요.");
            name[i] = scan.next();
            System.out.println(name[i].equals(("안녕")));
            System.out.println(name[i]);
            //점수 입력
            for(int j=0; j<score[i].length-1; j++) {
                System.out.println(subject[j+1] + "점수를 입력하세요");
                score[i][j] = scan.nextInt();
                //합계 입력
                score[i][score[i].length-1] += score[i][j];
            }
            avg[i] = score[i][score[i].length-1] / (score[i].length-1) ; // 합계/3 => 평균
        }

        //출력
        for (int i = 0; i < subject.length; ++i) {
            System.out.print(subject[i]+"\t");
        }
        System.out.println();

        //점수 출력
        for(int i=0; i<score.length; i++){ 
            //이름 출력
            System.out.print(name[i] + "\t");
            for(int j=0; j<score[i].length; j++) {
                System.out.print(score[i][j]+"\t");
            }
            //평균 출력
            System.out.println(avg[i] + "\n");
        }

        
    }
}