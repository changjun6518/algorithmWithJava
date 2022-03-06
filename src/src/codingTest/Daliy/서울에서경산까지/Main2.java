package codingTest.Daliy.서울에서경산까지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int footTime = Integer.parseInt(st.nextToken());
            int footMoney = Integer.parseInt(st.nextToken());
            int bikeTime = Integer.parseInt(st.nextToken());
            int bikeMoney = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[i][footTime] = footMoney;
                dp[i][bikeTime] = bikeMoney;
                if (footTime == bikeTime) {
                    dp[i][footTime] = Math.max(footMoney, bikeMoney);
                }
            } else {
                for (int j = 0; j <= K; j++) {
                    if (footTime + j <= K) {
                        dp[i][j + footTime] = Math.max(dp[i][j + footTime], dp[i - 1][j] + footMoney);
                    }
                    if (j + bikeTime <= K) {
                        dp[i][j + bikeTime] = Math.max(dp[i][j + bikeTime], dp[i - 1][j] + bikeMoney);
                    }
                }
            }
        }
        int answer = Arrays.stream(dp[N - 1]).max().getAsInt();
        System.out.println(answer);
    }
}
