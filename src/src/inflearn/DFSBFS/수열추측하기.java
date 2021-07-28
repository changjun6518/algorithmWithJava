package inflearn.DFSBFS;

import java.util.Scanner;

public class 수열추측하기 {
    static int n;
    static int r;
    static int memory[][];
    static int multiplication[], p[];
    static int check[];
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5 26
        n = sc.nextInt();
        r = sc.nextInt();
        memory = new int[n + 1][r + 1];
        multiplication = new int[n];
        p = new int[n];
        check = new int[n + 1];
        for (int i = 0; i < n; i++) {
            multiplication[i] = 조합(n - 1, i);
        }


        DFS(0,0);
    }
// 1 3 3 1
    public static void DFS(int level, int sum) {
        if (flag) {
            return;
        }
        if (level == n) {
            if (sum == r) {
                for (int i : p) {
                    System.out.print(i + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (multiplication[level] * p[level]));
                    check[i] = 0;
                }
            }
        }
    }
    public static int 조합(int N, int R) {
        if (memory[N][R] > 0) {
            return memory[N][R];
        }
        if (N == R || R == 0) {
            return 1;
        } else {
            return memory[N][R] = 조합(N - 1, R - 1) + 조합(N - 1, R);
        }
    }
}
