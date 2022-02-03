package codingTest.DynamicProgramming.다리놓기;

import java.util.Scanner;

public class Main {
    static int[][] dp = new int[30][30];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, M;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            answer.append(combi(M, N)).append("\n");
            System.out.println("count = " + count);
        }
        System.out.println(answer.toString());
    }

    public static int combi(int n, int r) {
        count++;
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
