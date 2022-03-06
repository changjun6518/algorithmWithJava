package codingTest.Daliy.서울에서경산까지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    static int N;
    static int K;
    static ArrayList<Activate> activates = new ArrayList<>();
    static int[][] dp = new int[101][100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            activates.add(new Activate(stoi(s[0]), stoi(s[1]), stoi(s[2]), stoi(s[3])));
        }
        for (int i = 1; i < N; i++) {
            Activate now = activates.get(i);
            if (i == 1) {
                dp[i][now.walkTime] = now.walkMoney;
                dp[i][now.cycleTime] = now.cycleMoney;
            } else {
                for (int j = 0; j <= K; j++) {
                    if (dp[i - 1][j] != 0) {
                        int nextWalkTime = j + now.walkTime;
                        if (nextWalkTime <= K) {
                            dp[i][nextWalkTime] = Math.max(dp[i][nextWalkTime], dp[i - 1][j] + now.walkMoney);
                        }
                        int nextCycleTime = j + now.cycleTime;
                        if (nextCycleTime <= K) {
                            dp[i][nextCycleTime] = Math.max(dp[i][nextCycleTime], dp[i - 1][j] + now.cycleMoney);
                        }
                    }
                }
            }
        }

        int answer = Arrays.stream(dp[N - 1])
                .max()
                .orElse(0);

        System.out.println(answer);
    }

    private static class Activate {
        int walkTime;
        int walkMoney;
        int cycleTime;
        int cycleMoney;

        public Activate(int walkTime, int walkMoney, int cycleTime, int cycleMoney) {
            this.walkTime = walkTime;
            this.walkMoney = walkMoney;
            this.cycleTime = cycleTime;
            this.cycleMoney = cycleMoney;
        }
    }

    private static int stoi(String num) {
        return Integer.parseInt(num);
    }
}
