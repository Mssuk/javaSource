package app;

/**
 * Ex0219_05
 */
public class Ex0219_05 {

    public static void main(String[] args) {
        // factorial
        System.out.println(factorial(10));
    }

    static long factorial(int n) {
        long result = 0;
        if (n == 1) {
            result = 1;
        } else {
            result = factorial(n - 1) * n;
        }
        return result;
    }

}