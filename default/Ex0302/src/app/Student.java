package app;

/**
 * Student
 */
public class Student {

    static int count;
    int hak_num;
    String name;
    int kor;
    int eng;
    int total;
    float avg;
    int rank;

    Student(){

    }

    Student(String name, int kor, int eng){
        hak_num = ++count;
        this.name =name;
        this.kor = kor;
        this.eng = eng;
        this.total = kor+eng;
        this.avg = (kor+eng)/2;
    }
}