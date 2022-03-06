package codingTest.DynamicProgramming.평범한배낭;

import java.util.Scanner;

public class Main {
    static int[] W = new int[100001];
    static int[] V = new int[1001];
    static int[][] dp = new int[101][100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        // i 는 물품수
        // j 는 버틸 수 있는 무게

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - W[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
