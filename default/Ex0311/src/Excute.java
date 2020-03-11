import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Excute {
    //실행 메소드 모음

    ArrayList<Student> students = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    HashMap<String, String> admin = new HashMap<>();
    boolean adminLogin = false;

    Excute() {
        //sample data
        students.add(new Student("홍길동", 90, 100, 40));
        students.add(new Student("고길동", 20, 20, 10));
        students.add(new Student("박길금", 40, 90, 70));
        admin.put("admin", "qwerty");

    }


    void showMenu() {

        System.out.println("[학생성적프로그램]");
        System.out.println("----------------");
        System.out.println("1)성적입력");
        System.out.println("2)학생출력");
        System.out.println("3)학생검색");
        System.out.println("4)등수확인");
        System.out.println(adminLogin ? "5)관리자 로그아웃" : "5)관리자로그인");
        System.out.println("----------------");
        System.out.print(adminLogin ? "당신은 관리자입니다\n" : "");

    }


    private int validate(String sub) {
        int score = -1;
        do {
            try {
                System.out.println(sub + "점수를 입력하세요.");
                score = scan.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("점수범위 0~100입니다.");
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력값");
                score = -1;
                scan.nextLine();
            }
        } while (score == -1);

        return score;
    }


    void addStu() {
        System.out.println("이름을 입력하세요. 0)취소");
        String name = scan.next();
        if(name.equals("0")){
            return;
        }

        int kor = validate("국어");
        int eng = validate("영어");
        int math = validate("수학");

        students.add(new Student(name, kor, eng, math));
    }



    void showStu(List<Student> list) {

        if (list == null) {
            list = students;
        }
        if (list.isEmpty()) {
            System.out.println("일치하는 데이터 없음");
            return;
        }

        System.out.print("학번\t이름\t\t국어\t영어\t수학\t합계\t평균\t\t등수\n");

        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }


    void searchStu() {
        System.out.println("찾을 단어 1글자 이상 입력하세요.");
        String word = scan.next();
        List<Student> result = students.stream()
                .filter(o -> o.getName().contains(word))
                .collect(Collectors.toList());

        showStu(result);

    }


    void checkRank() {
        int rank = 1;
        for (int i = 0; i < students.size(); ++i) {
            rank = 1;
            for (int j = 0; j < students.size(); ++j) {
                if (students.get(i).getAvg() < students.get(j).getAvg()) {
                    rank++;
                }
            }
            students.get(i).setRank(rank);
        }
        System.out.println("등수 계산 완료");
        showStu(students);
    }

    void administerLogin() {
        if (adminLogin) {
            System.out.println("로그아웃합니다.");
            adminLogin = false;
            return;
        }
        System.out.println("관리자 로그인 페이지");
        System.out.println("아이디를 입력하세요.");
        String id = scan.next();
        String judge = admin.get(id);
        if (judge == null) {
            System.out.println("아이디가 다릅니다.");
            return;
        }
        System.out.println("비밀번호를 입력하세요.");
        String pw = scan.next();
        if (judge.equals(pw)) {
            System.out.println("로그인 완료");
            adminLogin = true;
        } else {
            System.out.println("비밀번호가 다릅니다. 다시 로그인해주세요");
        }
    }


}
