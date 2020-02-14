package app;

import java.util.Scanner;

/**
 * Ex0214_01
 */
public class Ex0214_01 {

    public static void main(String[] args) {
        
//, "레스터시티FC", "첼시FC","셰필드유나이티드FC","토트넘홋스퍼FC","에버턴FC","맨체스터유나이티드FC"
/*
24 1 0      73 1
16 3 6      51 2
15 4 6      49 3
12 5 8      41 4
10 9 7      39 5
10 7 8      37 6
10 6 10     36 7
9 8 8       35 8

*/
        Scanner scan = new Scanner(System.in, "euc-kr");
        String[] subjects = {"팀","승","무","패","승점","순위"};
        String[] teams = {"리버풀FC", "맨체스터시티FC","레스터시티FC", "첼시FC","셰필드유나이티드FC","토트넘홋스퍼FC","에버턴FC","맨체스터유나이티드FC"};
        int[][] score = new int[teams.length][5]; //승,무,패,승점,순위 담는 배열
        int rank=1;

        for(int i=0; i<teams.length; ++i){
            for(int j=0; j<score[i].length-2; ++j){
                System.out.println(teams[i]+"의 "+subjects[j+1]+"를 입력하세요.");
                score[i][j] = scan.nextInt();
            }
            //승점 계산
            score[i][score[i].length-2] += (score[i][0] * 3) + (score[i][1]* 1); 
        }
        //순위계산
        for(int i=0; i<score.length; ++i){
            rank = 1;
            for(int j=0; j<score.length; ++j){
                if(score[i][score[i].length-2] < score[j][score[j].length-2]){
                    rank++;
                }
            }
            score[i][score[i].length-1] = rank;
        }
                

    
        int yame =0;
        for(int i=0; i<teams.length; ++i){
            if(teams[i].length()>yame){
                yame = teams[i].length();
            }
        }

        // System.out.printf("%15.15s", subjects[0]);
        // for(int i=1; i<subjects.length; ++i){
        //     System.out.printf("%-15.15s", subjects[i]);
        // }
        // System.out.println();

        for(int i=0; i<score.length; ++i){
            int temp = yame - teams[i].length();
            if(temp!=0){
                for(int k=0; k<temp; ++k){
                    teams[i]+="        ";
                }
            }
            System.out.printf("%-22s",teams[i]);
            for(int j=0; j<score[i].length; ++j){
                System.out.printf("%-22d", score[i][j]);
            }
            System.out.println();
        }





    }//main
} //class