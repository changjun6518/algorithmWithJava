package practice.순열;

import java.util.Scanner;

public class Main {
    static int N;
    static int R;
    static boolean[] visited;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) {
        // 뭐할까?
        // 순열이 뭘까
        // 순서를 가진다
        // n개중 r 개 뽑았을 때 순서가 있으면? 순열

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();
        visited = new boolean[N + 1];
        arr = new int[R];
        DFS(0);
        System.out.println("count = " + count);
    }

    private static void DFS(int level) {
        if (level == R) {
            count++;
            for (int i = 0; i < R; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[level] = i;
                    DFS(level + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
