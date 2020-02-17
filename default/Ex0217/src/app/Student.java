package app;

/**
 * Student
 */
public class Student {

    String name; //이름
    int[] score; //점수
    double avg; //평균
    int rank; //등수

    public Student(){
        System.out.println("생성");
        score = new int[4];
    }

    void total(){
        for(int i=0; i<score.length-1; ++i){
            score[score.length-1] += score[i];
        }
    }
    double getAvg(){
        avg = score[score.length-1] / 3.0;
        return avg;
    }
    void printScore(){
        for(int i=0; i<score.length; ++i){
           System.out.print(score[i] +"\t"); 
        }
    }
}

