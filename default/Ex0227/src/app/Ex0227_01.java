package app;

/**
 * Ex0227_01
 */

 //싱글톤 패턴
public class Ex0227_01 {

    public static void main(String[] args) {
            Stu01  s = Stu01.getInstance();
            Stu01 s2 = Stu01.getInstance();

            System.out.println(s);
            System.out.println(s2);
    }
}