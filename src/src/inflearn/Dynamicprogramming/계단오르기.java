package inflearn.Dynamicprogramming;

import java.util.Scanner;

public class 계단오르기 {
    static int[] dy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n + 1];

        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int k) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= k; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[k];
    }
}
