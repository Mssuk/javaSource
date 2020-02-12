import java.util.Scanner;

/**
 * Ex0211_08
 */
public class Ex0211_08 {

    public static void main(String[] args) {
        //Exercise 1
        //소수점 숫자 2개를 입력받아서
        // 사칙연산
        // 소수점은 둘째 자리까지 나타낼 수 있도록 하라.
        
        float[] fnum = new float[2];
        Scanner scan = new Scanner(System.in);

        System.out.println("첫 번째 수를 입력하세요.>>>>");
        fnum[0] = scan.nextFloat();
        System.out.println("두 번째 수를 입력하세요.>>>>");
        fnum[1] = scan.nextFloat();

        System.out.println("----- 두 수의 사칙연산 결과 ------");
        System.out.printf("두 수의 합: %.2f  , 두 수의 차: %.2f, 두 수의 곱셈: %.2f, 두 수의 나눗셈: %.2f", fnum[0] +fnum[1], fnum[0] - fnum[1], fnum[0] *fnum[1], fnum[0] /fnum[1] );

    }
}