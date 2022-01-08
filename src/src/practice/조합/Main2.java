package practice.조합;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    static int N;
    static int R;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) {
        // 중복 허용 안하고
        // 5 2
        // 1 2, 1 3, 1 4, 1 5, 2 3, 2 4, 2 5, 3 4, 3 5, 4 5

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }
        visited = new int[R];

        DFS(0, 1);
    }

    public static void DFS(int level, int start) {
        if (level == R) {
            for (int i = 0; i < R; i++) {
                System.out.print(arr[visited[i]] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= N; i++) {
                visited[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }
}
