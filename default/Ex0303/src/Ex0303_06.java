import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ex0303_06
 */
public class Ex0303_06 {

    /*
     * 1)학생정보입력 -학번 -이름 -과 -학년
     * 
     * 2) 학생성적처리입력 -학번 (학번이 없으면 학생정보입력 다시하세요 -> 에러메시지) -학번 ... 입력하면 이름이 자동으로 찍힘.
     * -국어점수 -영어점수 -합계 -평균 -등수
     * 
     * 
     * 3)학생정보출력
     * 
     * 4)학생성적출력
     * 
     * 5)학생정보검색
     * 
     * 6)학생성적검색
     * 
     * 
     */

    static Scanner scan = new Scanner(System.in, "euc-kr");

    public static void main(String[] args) {

        // 학생들이 담겨있는 ArrayList
        ArrayList<Student> people = new ArrayList<>();
        // 학생의 성적이 담겨있는 ArrayList
        ArrayList<Stu_score> scores = new ArrayList<>();

        while (true) {
            int menu = 0;
            try {
                printMenu();
                menu = scan.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력해야 합니다.");
                scan.nextLine();
                continue;
            }
            ;
            switch (menu) {
                case 1:
                    pushStu(people, scores);
                    break;

                case 2:
                    pushScore(people, scores);
                    break;

                case 3:
                    printStuInfo(people);
                    break;

                case 4:
                    printStuScore(scores);
                    break;

                case 5:
                    bigSearchInfo(people);
                    break;

                case 6:
                    bigSearchScore(scores);
                    break;
                default:
                    System.out.println("잘못된 범위 값 입력하였습니다.");
                    break;
            }
        }

    }// main

    static void printMenu() {

        System.out.println();
        System.out.println("1)학생정보 입력");
        System.out.println("2)학생성적 입력");
        System.out.println("3)학생정보 출력");
        System.out.println("4)학생성적 출력");
        System.out.println("5)학생정보 검색");
        System.out.println("6)학생성적 검색");
    }

    //학생 정보 입력
    static void pushStu(ArrayList<Student> stu, ArrayList<Stu_score> scores) {
        System.out.println("[학생정보 입력]");
        System.out.println("학생의 이름은 무엇인가요?");
        String name = scan.next();
        System.out.println("학생의 과는 무엇인가요?");
        String major = scan.next();
        System.out.println("학생은 몇학년 인가요?");
        int grade = 0;
        while (grade == 0) {
            try {
                grade = pushGrade();
            } catch (Exception e) {
                continue;
            }
        }
        Student s = new Student(name, major, grade);
        stu.add(s);
        scores.add(new Stu_score(s));

        System.out.println("학생 정보 입력이 완료 되었습니다.");

    }

    //학생 학년 입력
    static int pushGrade() throws Exception {
        int grade = 0;
        try {
            grade = scan.nextInt();
            if (grade < 1 || grade > 4) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("학년은 1~4 범위의 숫자여야 합니다.");
            scan.next();
        }

        return grade;
    }

    //학생 정보 출력(모두출력)
    static void printStuInfo(ArrayList<Student> stu) {
        System.out.println("[학생 정보 출력]");

        System.out.print("학번\t이름\t과\t학년\t\n");

        for (int i = 0; i < stu.size(); ++i) {
            Student stuone = stu.get(i);
            System.out.print(stuone);
        }
        System.out.println();
    }

    //학생 성적 출력 (모두출력)
    static void printStuScore(ArrayList<Stu_score> stu_score) {
        System.out.println("[학생 성적 출력]");
        System.out.print("학번\t이름\t국어\t영어\t합계\t평균\t등수\n");

        for (int i = 0; i < stu_score.size(); ++i) {
            Stu_score stu_one = stu_score.get(i);
            System.out.print(stu_one);
        }
    }

    //학생 성적 입력
    static void pushScore(ArrayList<Student> stu, ArrayList<Stu_score> stu_score) {
        System.out.println("[학생성적입력]");
        System.out.println("학번을 입력하세요.");
        int hakbun = 0;
        while (hakbun == 0) {
            try {
                hakbun = scan.nextInt();
            } catch (Exception e) {
                System.out.println("학번은 숫자입니다. 다시 입력하세요.");
                scan.next();
                continue;
            }
        }
        Student ss = searchStuInfo(stu, hakbun);
        if (ss == null) {
            System.out.println("입력되지 않은 학번입니다..");
            System.out.println("학생정보 입력을 먼저하세요. !!!!!");
            return;
        }
        System.out.println("이름 :" + ss.name);

        Stu_score ss_s = searchScore(stu_score, ss);

        int kor = -1;
        while (kor == -1) {
            try {
                kor = pushSco("국어");
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println(kor);
        ss_s.kor = kor;

        int eng = -1;
        while (eng == -1) {
            try {
                eng = pushSco("영어");
            } catch (Exception e) {
                continue;
            }
        }
        ss_s.eng = eng;

        ss_s.calTotalAvg();

        setScore(stu_score);

        // System.out.println();

    }

    //학생 정보검색
    static void bigSearchInfo(ArrayList<Student> stu) {
        System.out.println("[학생 정보 검색]");
        System.out.println("1) 이름으로 찾기 2) 학번으로 찾기");
        int menu = scan.nextInt();
        Student s = null;
        switch (menu) {
            case 1:
                System.out.println("찾고 싶은 이름은?");
                String name = scan.next();
                s = searchStuInfo(stu, name);
                break;

            case 2:
                System.out.println("찾고 싶은 학번은?");
                int bunho = scan.nextInt();
                s = searchStuInfo(stu, bunho);
                break;

            default:
                System.out.println("잘못된 입력");
                break;
        }
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("찾는 학생이 없습니다.");
        }
    }

    //정보검색1 이름으로
    static Student searchStuInfo(ArrayList<Student> stu, String name) {
        for (int i = 0; i < stu.size(); ++i) {
            if (stu.get(i).name.equals(name)) {
                return stu.get(i);
            }
        }
        return null;
    }

    //정보검색2 학번으로
    static Student searchStuInfo(ArrayList<Student> stu, int hakbun) {

        for (int i = 0; i < stu.size(); ++i) {
            if (stu.get(i).hakbun == hakbun) {
                return stu.get(i);
            }
        }
        return null;
    }

    //학생성적 검색
    static void bigSearchScore(ArrayList<Stu_score> scores) {
        System.out.println("[학생 성적 검색]");
        System.out.println("1) 이름으로 찾기 2) 학번으로 찾기");
        int menu = scan.nextInt();
        Stu_score s = null;
        switch (menu) {
            case 1:
                System.out.println("찾고 싶은 이름은?");
                String name = scan.next();
                s = searchScore(scores, name);
                break;

            case 2:
                System.out.println("찾고 싶은 학번은?");
                int bunho = scan.nextInt();
                s = searchScore(scores, bunho);
                break;

            default:
                System.out.println("잘못된 입력");
                break;
        }
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("찾는 학생이 없습니다.");
        }
    }

    //학생생적 검색 1 학번으로
    static Stu_score searchScore(ArrayList<Stu_score> scores, int ss_i) {

        for (int i = 0; i < scores.size(); ++i) {
            if (scores.get(i).realStu.hakbun == ss_i) {
                return scores.get(i);
            }
        }
        return null;
    }

    //학생성적 검색2 이름으로
    static Stu_score searchScore(ArrayList<Stu_score> scores, String ss_s) {

        for (int i = 0; i < scores.size(); ++i) {
            if (scores.get(i).realStu.name.equals(ss_s)) {
                return scores.get(i);
            }
        }
        return null;
    }

    //학생성적 검색3 객체로(내부용)
    static Stu_score searchScore(ArrayList<Stu_score> scores, Student ss) {

        for (int i = 0; i < scores.size(); ++i) {
            if (scores.get(i).realStu.equals(ss)) {
                return scores.get(i);
            }
        }
        return null;
    }

    //성적 입력
    static int pushSco(String subject) throws Exception {
        System.out.println(subject + "점수를 입력하세요.");
        int score = -1;
        try {
            score = scan.nextInt();
            if (score < 0 || score > 100) {
                throw new Exception();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("점수는 0~100 사이 범위의 숫자입니다.");
            scan.nextLine();
        }
        return score;
    }

    //등수 정하기
    static void setScore(ArrayList<Stu_score> stus) {
        int my_rank;
        for (int i = 0; i < stus.size(); ++i) {
            my_rank = 1;
            for (int j = 0; j < stus.size(); ++j) {
                if (stus.get(i).avg < stus.get(j).avg) {
                    my_rank++;
                }
            }
            stus.get(i).rank = my_rank;
        }

    }

} // class

class Student {

    static int numbering = 1000;
    int hakbun;
    String name;
    String major;
    int grade;

    public Student(String name, String major, int grade) {
        hakbun = ++numbering;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%d\t%s\t%s\t%d\t\n", hakbun, name, major, grade);
    }

}

class Stu_score {

    Student realStu;
    int kor;
    int eng;
    int total;
    double avg;
    int rank;

    public Stu_score(Student realStu) {
        this.realStu = realStu;
    }

    void calTotalAvg() {
        total = kor + eng;
        setAvg();
    }

    private void setAvg() {
        avg = total / 2.0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%d\t%s\t%d\t%d\t%d\t%.1f\t%d\t\n", realStu.hakbun, realStu.name, kor, eng, total, avg,
                rank);
    }
}
