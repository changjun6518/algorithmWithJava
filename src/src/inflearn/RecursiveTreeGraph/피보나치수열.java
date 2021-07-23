package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 피보나치수열 {
    static int[] fibo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fibo = new int[num + 1];
        bfs(num);

        for (int i = 1; i <= num; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public static int bfs(int num) {
        if (fibo[num] > 0) {
            return fibo[num];
        }
        if (num == 1 || num == 2) {
            return fibo[num] = 1;
        } else {
            return fibo[num] = bfs(num - 1) + bfs(num - 2);
        }

    }
}
