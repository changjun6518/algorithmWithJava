package codingTest.Daliy.동전뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'T') {
                    map[i][j] = 1;
                }
            }
        }

        int answer = 400;
        for (int bit = 0; bit < (1 << n) - 1; bit++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int tail = 0;

                for (int j = 0; j < n; j++) {
                    int cur = map[j][i];
                    if ((bit & (1 << j)) != 0) {
                        cur = map[j][i] ^ 1;
                    }
                    if (cur == 1) tail++;
                }
                sum += Math.min(tail, n - tail);
            }
            if (answer>sum) answer = sum;
        }

        System.out.println(answer);
        br.close();
    }
}
