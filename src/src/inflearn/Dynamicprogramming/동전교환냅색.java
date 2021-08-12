package inflearn.Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환냅색 {
    static int[] dy;
    static int n, m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        dy = new int[m + 1];

        System.out.println(solution(coins));

    }

    public static int solution(int[] coins) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j < m + 1; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }
        return dy[m];
    }

}
//3
//1 2 5
//15