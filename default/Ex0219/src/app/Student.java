package app;

/**
 * Student
 */
public class Student {

    String name;
    int kor;
    int eng;
    int math;
    int total;
    double avg;

    Student() {

    }

    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor + eng + math;
        avg = total / 3;
    }

    void printInfo() {
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f%n", name, kor, eng, math, total, avg);
    }
}