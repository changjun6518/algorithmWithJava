package inflearn.DFSBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 동전교환 {
    static int totalCount;
    static Integer[] coins;
    static int exchangeMoney;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        totalCount = sc.nextInt();
        coins = new Integer[totalCount];
        for (int i = 0; i < totalCount; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        exchangeMoney = sc.nextInt();

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum) {
        if (sum > exchangeMoney) {
            return;
        }
        if (level >= answer) {
            return;
        }
        if (sum == exchangeMoney) {
            answer = Math.min(level, answer);
        } else {
            for (int i = 0; i < totalCount; i++) {
                DFS(level + 1, sum + coins[i]);
            }
        }
    }


}
//3
//1 2 5
//15
