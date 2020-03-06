import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ex0306_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] hak_num = {1001, 1002, 1003};
        String[] name= {"홍길동","이순신","김유신"};
        int[] total = {299, 288, 300};
        ArrayList<Student> list = new ArrayList<>();

        for(int i=0; i<hak_num.length; ++i){
            list.add(new Student(hak_num[i], name[i], total[i]));
        }

        while(true){
            System.out.println("1)학번정렬 2)이름정렬 3)점수정렬");
            int num = scan.nextInt();
            switch(num){
                case 1:
                    Collections.sort(list, ((o1, o2) -> {
                        if(o1.hak_num < o2.hak_num){
                            return -1;
                        } else{
                            return 1;
                        }
                    }));
                    for (var a:
                         list) {
                        System.out.println(a);
                    }

                    break;
                case 2:
                    Collections.sort(list, ((o1, o2) -> {
                        return o1.name.compareTo(o2.name);
                    }));
                    for (var a:
                            list) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    list.sort(Comparator.comparingInt(o -> o.total));
                    for (var a:
                            list) {
                        System.out.println(a);
                    }
                    break;

            }
        }
    } //main
} //class
