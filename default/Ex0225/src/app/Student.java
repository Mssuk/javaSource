package app;

/**
 * Student
 */
public class Student {

    static int count = 1000;
    int hak_num;
    String name;
    int grade;

    // 초기화 블럭
    {
        count++;
        hak_num = count;
    }

    Student() {

    }

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}