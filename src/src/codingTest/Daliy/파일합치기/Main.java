package codingTest.Daliy.파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] sum = new int[n];
            sum[0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                sum[j] = Integer.parseInt(st.nextToken()) + sum[j - 1];
            }
            sb.append(solution(n, sum)).append('\n');
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static int solution(int n, int[] sum) {
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    int cost = dp[j][j + k] + dp[j + k + 1][j + i] + sum[i + j];
                    if (j - 1 >= 0) {
                        cost -= sum[j - 1];
                    }
                    dp[j][j + i] = Math.min(dp[j][j + i], cost);
                }
            }
        }
        return dp[0][n - 1];
    }
}
