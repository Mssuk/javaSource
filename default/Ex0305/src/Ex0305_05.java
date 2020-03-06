import java.util.ArrayList;
import java.util.Collections;

public class Ex0305_05 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Student> list2 = new ArrayList<>();
        Student stu1 = new Student(1, "홍길동", 300);
        Student stu2 = new Student(2, "김유신", 298);
        Student stu3 = new Student(4, "이순신", 280);
        Student stu4 = new Student(5, "유관순", 270);
        Student stu5 = new Student(3, "강감찬", 299);

        list.add(5);
        list.add(9);
        list.add(1, 7);
        list.add(9);

        //list.remove(1);


//        int a= 5;
//        int b= 6;

        list.clear();
        System.out.println(list);

        list2.add(stu1);
        list2.add(stu2);
        list2.add(stu3);
        list2.add(stu4);
        list2.add(stu5);


//        for (var a:
//             list2) {
//            System.out.println(a);
//        }
        System.out.println(list2);

        Collections.sort(list2);

        for (var a :
                list2) {
            System.out.println(a);
        }


        System.out.println(list);

    }

}
