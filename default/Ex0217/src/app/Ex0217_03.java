package app;

import java.util.Scanner;

/**
 * Ex0217_03
 */
public class Ex0217_03 {
    public static void main(String[] args) {
      
        //5명 학생의 이름, 국어, 영어, 수학 점수를 입력받아 합계, 평균 내기
        Scanner scan = new Scanner(System.in, "euc-kr");
        String[] subject = { "이름", "국어", "영어", "수학", "합계", "평균" };

        Student[] stu = new Student[3]; // 5명의 학생
        for (int i = 0; i < stu.length; ++i) {
            stu[i] = new Student();
            System.out.println("이름을 입력");
            stu[i].name = scan.next();
            for (int j = 0; j < stu[i].score.length - 1; ++j) {
                System.out.println(i + 1 + "번째 학생의 " + subject[j + 1] + "점수를 입력");
                stu[i].score[j] = scan.nextInt();
            }
            stu[i].total();
        }

        // 제목 출력
        for (int i = 0; i < subject.length; ++i) {
            System.out.print(subject[i] + "\t");
        }
        System.out.println();
        //내용 출력
        for (int i = 0; i < stu.length; ++i) {
            System.out.print(stu[i].name + "\t");
            stu[i].printScore();
            System.out.printf("%.1f%n", stu[i].getAvg());
        }


        //String[] name= new String[5];
        //int[][] score = new int[name.length][4];
        //double[] avg = new double[name.length];
    
        // for(int i=0; i<score.length; ++i){
        //     System.out.println("이름을 입력");
        //     name[i] = scan.next();
        //     for(int j=0; j<score[i].length-1; ++j){
        //             System.out.println(i+1 + "번째 학생의 "+subject[j+1]+ "점수를 입력");
        //             score[i][j] = scan.nextInt();

        //             //sum
        //             score[i][score[i].length-1] += score[i][j];
        //     }
        //     //avg
        //     avg[i] = score[i][score[i].length-1] / 3.0;
        // }

        // //출력
        // for(int i=0; i<subject.length; ++i){
        //     System.out.print(subject[i]+"\t");
        // }
        // System.out.println();
        // for(int i=0; i<score.length; ++i){
        //     System.out.print(name[i]+"\t");
        //     for(int j=0; j<score[i].length; ++j){
        //         System.out.print(score[i][j]+"\t");
        //     }
        //     System.out.printf("%.1f%n", avg[i]);
        // }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Student stu1 = new Student();
        // stu1.name = "홍길동";
        // stu1.kor = 100;
        // stu1.eng = 100;
        // stu1.math = 90;
        // stu1.total = stu1.eng + stu1.kor + stu1.math;
        // stu1.avg = stu1.total/ 3.0;
        // stu1.rank = 1;

        //System.out.println(stu1.name+" "+ stu1.kor+" "+stu1.eng+" "+ stu1.math+" "+stu1.total+" "+ stu1.avg+" "+ stu1.rank);

        // Tv t1 = new Tv();
        // Tv t2 = new Tv();
        // t1.channel = 10;
        // System.out.println(t2.channel);
        
    }
}