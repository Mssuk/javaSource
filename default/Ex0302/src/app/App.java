package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       

            Scanner scan = new Scanner(System.in);
            int n =scan.nextInt();

            int[] dp = new int[31];
            dp[0] = 1 ; dp[1] = 0 ;  dp[2] = 3;
    
            if(n%2 == 0 ) {
                for (int i = 4; i <= n; i = i + 2) {
                    dp[i] += dp[i - 2] * 3;
                    for (int j = 4; i-j >=0 ; j = j+2) {
                        dp[i] += dp[i-j] *2;
                    }
                }
            }
    
            System.out.println(dp[n]);
    


    }

}