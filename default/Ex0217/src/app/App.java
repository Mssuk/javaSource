package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    static int arr[][] = new int[50][5];
    static int moveX[] = { 1, 0, -1, 0 };
    static int moveY[] = { 0, -1, 0, 1 };
    static int r1, r2, c1, c2;
    static int maxCount, maxValue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        maxCount = (Math.abs(r1 - r2) + 1) * (Math.abs(c1 - c2) + 1);

        solve();

        int space = len(maxValue);
        for (int i = 0; i <= Math.abs(r1 - r2); i++) {
            for (int j = 0; j <= Math.abs(c1 - c2); j++) {
                int currentSpace = len(arr[i][j]);
                for (int k = 0; k < space - currentSpace; k++)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // for(int i=0; i<50; i++) {
        // for(int j=0; j<5; j++) {
        // System.out.print(arr[i][j]+" ");
        // }System.out.println();
        // }

    }

    public static int len(int value) {
        int result = 0;
        while (value >= 10) {
            result++;
            value /= 10;
        }
        return result;
    }

    public static void solve() {
        int x = 0, y = 0;
        int val = 1;
        int cnt = 1;
        int d = 0;
        int len = 0;
        boolean visit = false;

        if (r1 <= y && y <= r2 && c1 <= x && x <= c2) {
            arr[y - r1][x - c1] = val++;
            cnt++;
            visit = true;
        }
        if (!visit)
            val++;

        while (cnt <= maxCount) {
            d %= 4;
            if (d == 0 || d == 2)
                len++;
            for (int i = 0; i < len; i++) {
                x += moveX[d];
                y += moveY[d];
                if (r1 <= y && y <= r2 && c1 <= x && x <= c2) {
                    arr[y - r1][x - c1] = val;
                    maxValue = Math.max(maxValue, val);
                    cnt++;
                }
                val++;
            }
            d++;
        }

    }
}