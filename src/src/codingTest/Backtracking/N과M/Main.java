package codingTest.Backtracking.N과M;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
    }

    public static void dfs(int level) {
        if (level == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i - 1]) {
                    visited[i-1] = true;
                    arr[level] = i;
                    dfs(level + 1);
                    visited[i-1] = false;
                }
            }
        }

    }
}
