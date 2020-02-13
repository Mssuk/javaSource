package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * App2 #include <stdio.h>
 * 
 * int main(void) { int a; int b; scanf("%d %d", &a, &b); printf("%d", a + b);
 * return 0; }
 */

public class App2 {

    public static void main(String[] args) throws IOException {
        // 표준 입력

        int i, j;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        i = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());
        for (int k = 0; k < j; ++k) {
            for (int l = 0; l < i; ++l) {
                System.out.print("*");
            }
            if (k < j - 1) {
                System.out.println();
            }
        }

    }
}