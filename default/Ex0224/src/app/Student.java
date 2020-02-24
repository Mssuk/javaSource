package app;

/**
 * Student
 */
public class Student {

    static int scount;
    String name;
    int kor;
    int eng;
    int math;
    int total;
    double avg;
    int no;
    int rank;

    {
        scount++;
        no = scount;
    }

    Student(){
        this("홍길동",50,50,50);
    }
    Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        modify();
    }


    void modify(){
        total = kor+eng+math;
        avg = total / 3.0;
        rank =0;
    }
    
    @Override
    public String toString() {
        return no + "\t" + name + "\t"+ kor + "\t"+eng+ "\t"+math + "\t"+total + "\t"+ String.format("%.1f", avg);
    }

}