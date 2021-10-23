package inflearn2.DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 조합구하기 {
    static int N;
    static int R;
    static int[] arr;
    static boolean[] visited;
    // 4개 중 2개 뽑기 가자
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();
        arr = new int[R];
        visited = new boolean[N + 1];
        DFS(1, 0);
    }

    private static void DFS(int start, int level) {
        if (level == R) {
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= N; i++) {
                arr[level] = i;
                DFS(i + 1, level + 1);

            }
        }
    }
}
