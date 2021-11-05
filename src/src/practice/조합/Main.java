package practice.조합;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int R;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        visited = new int[R];
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        visited = new int[R];
        DFS(0, 0);
    }

    private static void DFS(int start, int level) {
        if (level == R) {
            for (int i = 0; i < R; i++) {
                System.out.print(arr.get(visited[i]) + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < N; i++) {
                visited[level] = i;
                DFS(i + 1, level + 1);
            }
        }
    }
}
