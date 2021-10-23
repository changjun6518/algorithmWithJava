package inflearn2.DFSBFS;

import java.util.Scanner;

public class 수열추측하기 {
    static int N;
    static int F;
    static int[] arr;
    static boolean[] visited;
    static int[] b;
    static int[][] dy = new int[35][35];
    static boolean flag = false;
    private static int combi(int n, int r) {
        if(dy[n][r]>0) return dy[n][r];
        else if(n==r||r==0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        F = scanner.nextInt();
        arr = new int[N];
        visited = new boolean[N + 1];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = combi(N - 1, i);
        }
        DFS(0);

    }

    private static void DFS(int level) {
        if (flag) {
            return;
        }
        if (level == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i] * b[i];
            }
            if (sum == F) {
                for (int i = 0; i < N; i++) {
                    System.out.print(arr[i] + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    arr[level] = i;
                    visited[i] = true;
                    DFS(level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static void check() {

    }
}
