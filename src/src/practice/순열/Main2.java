package practice.순열;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    static int N;
    static int R;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        // 1 2 3
        // 1 2 4
        // 1 2 5
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();

        arr = new int[R];
        visited = new boolean[N + 1];
        DFS(0);
    }

    public static void DFS(int level) {
        System.out.println("level = " + level);
        if (level == R) {
            System.out.println(Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
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
