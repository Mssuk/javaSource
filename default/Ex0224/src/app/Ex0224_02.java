package app;

import java.util.Scanner;

/**
 * Ex0224.02
 */
public class Ex0224_02 {

    public static void main(String[] args) {

        Student[] stu = new Student[2]; // 학생 2명 객체배열
        int[] score = new int[3]; // 점수받는 배열
        int stu_count  = 0; //입력된 학생이 몇명인지 출력

        stu_count = inputInfo(stu, score);
        System.out.println("입력된 학생 : " + stu_count + "명");
        System.out.println(stu[0]);
        System.out.println(stu[1]);

        // 2명의 학생 - 홍길동 100, 100, 90 / 이순신 80 90 70
        // Student s1 = new Student("홍길동", 100, 100, 90);
        // Student s2 = new Student("이순신", 80, 90, 70);

        // System.out.printf("이름 : %s 국어점수: %d 영어점수 : %d 수학점수 : %d total : %d 평균 : %.1f
        // %n", s1.name, s1.kor, s1.eng, s1.math, s1.total , s1.avg);
        // System.out.printf("이름 : %s 국어점수: %d 영어점수 : %d 수학점수 : %d total : %d 평균 : %.1f
        // %n", s2.name, s2.kor, s2.eng, s2.math, s2.total , s2.avg);

        // System.out.println(s1);
        // System.out.println(s2);
    }// main

    static int inputInfo(Student[] stu, int[] score) {
        int stu_count = 0;
        Scanner scan = new Scanner(System.in, "euc-kr");

        for (int i = 0; i < stu.length; i++) {
            stu_count++;
            System.out.println("이름을 입력하세요>>>");
            String name = scan.next();
            for (int j = 0; j < 3; j++) {
                System.out.println("값을 입력하세요.>>>");
                score[j] = scan.nextInt();

            }
            stu[i] = new Student(name, score[0], score[1], score[2]);
        }
        return stu_count;

    }
}