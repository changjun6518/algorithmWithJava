package codingTest.DynamicProgramming.돌게임;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[] dp = new boolean[N + 1];

        if (N > 1) {
            dp[2] = true;

            for (int i = 4; i <= N; i++) {
                dp[i] = !dp[i - 1];
            }
        }

        if (dp[N]) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
