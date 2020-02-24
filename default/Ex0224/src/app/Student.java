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

    Student(){
        this("홍길동",50,50,50);
    }
    Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor+eng+math;
        avg = total / 3.0;
    }
    
    @Override
    public String toString() {
        return "이름 : " + name + " 국어점수 : "+ kor + "  영어점수 : "+eng+ " 수학점수 : "+math + " total : "+total + " avg : "+ String.format("%.1f", avg);
    }

}