package BaekJoon;

import java.util.Scanner;

public class 퇴사_14501 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] dp = new int[21];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int Time = sc.nextInt();
            int Pay = sc.nextInt();

            //체크를 위해서
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            //Pay를 비교하는것
            dp[i + Time] = Math.max(dp[i + Time], dp[i] + Pay);
        }
        System.out.println(dp[N]);
    }
}
