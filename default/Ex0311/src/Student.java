public class Student {
    //학번, 이름 ,국어, 영어, 수학, 합계, 평균, 등수
    //3개정도는 기본으로 입력시켜놓고
    //입력을 1개씩 추가로 받을 수 있게 만들어보세요.
    private static int counter = 1;
    private int hakbun;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getAvg() {
        return avg;
    }

    private int sum;
    private double avg;
    private int rank;

    public String getName() {
        return name;
    }

    public Student(String name, int kor, int eng, int math) {
        hakbun = counter++;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        totalAvg();
    }

    public void totalAvg() {
        sum = kor + eng + math;
        avg = sum / 3.0;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s", hakbun, name, kor, eng, math, sum, avg, (rank == 0 ? "계산안됨" : rank + ""));
    }
}


