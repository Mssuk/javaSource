import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ex0303_03
 */
public class Ex0303_03 {

    public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in,"euc-kr");
        String name = "";
        int kor = 0;
        int eng = 0;

        System.out.println("이름을 입력하세요.");
        name = scan.nextLine();
        try{
            System.out.println("국어 점수 입력하세요.");
            kor = scan.nextInt();
        }
        catch(InputMismatchException e){
            e.printStackTrace();
            System.out.println("점수는 숫자여야합니다.");
            return;
        }

        try{
            System.out.println("영어 점수 입력하세요.");
            eng = scan.nextInt();
        }
        catch(Exception e){
            System.out.println("점수는 숫자여야합니다.");
            return;
        }
    }
}