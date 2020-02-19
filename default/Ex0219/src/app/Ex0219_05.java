package app;

import java.util.Scanner;

/**
 * Ex0219_05
 */
public class Ex0219_05 {

    public static void main(String[] args) {
        // factorial
        Scanner scan = new Scanner(System.in);
        System.out.println("원하는 숫자를 입력하세요>>");
        System.out.println(factorial(scan.nextInt()));
    }

    static long factorial(long n) {
        long result = 0;
        if (n == 1) {
            result = 1;
        } else {
            result = factorial(n - 1) * n;
        }
        return result;
    }
    
}