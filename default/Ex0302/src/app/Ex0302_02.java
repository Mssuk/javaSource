package app;

import java.util.*;

/**
 * Ex0302_02
 */
public class Ex0302_02 {

    public static void main(String[] args) {

        ArrayList<Stu_info> info = new ArrayList<>();
        Scanner scan = new Scanner(System.in, "euc-kr");

        String name = "";
        String major;
        int grade;
        int tel;
        int count = 0;

        while (count++ < 3) {
            System.out.println("이름을 입력해주세요.>>");
            name = scan.next();
            System.out.println("학과를 입력하세요.>>");
            major = scan.next();
            System.out.println("학년을 입력하세요.>>");
            grade = scan.nextInt();
            System.out.println("전화번호를 입력하세요.>>");
            tel = scan.nextInt();

            info.add(new Stu_info(name, major, grade, tel));
            System.out.println("1명 학생정보가 추가가 되었습니다.");
        }

        if (info.isEmpty()) {
            System.out.println("학생 입력이 없습니다.");
        } else {
            String str = String.format("학번\t이름\t학과\t학년\t전화");

            System.out.println(str);

            for (int i = 0; i < info.size(); ++i) {
                Stu_info s = info.get(i);
                System.out.print(s.hak_num + "\t");
                System.out.print(s.name + "\t");
                System.out.print(s.major + "\t");
                System.out.print(s.grade + "\t");
                System.out.print(s.tel + "\t");
                System.out.println();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////
        // Sudent
        // 학생 10명
        // 성적처리 프로그램

        // Vector<Student> list = new Vector<>();
        // String[] name1 = { "홍길동", "이순신", "김유신" };
        // int[] kor1 = { 100, 90, 95 };
        // int[] eng1 = { 80, 70, 89 };

        // ArrayList<Student> list2 = new ArrayList<>();

        // list2.add(new Student(name1[0], kor1[0], eng1[0]));
        // list2.add(new Student(name1[1], kor1[1], eng1[1]));
        // list2.add(new Student(name1[2], kor1[2], eng1[2]));

    }
}