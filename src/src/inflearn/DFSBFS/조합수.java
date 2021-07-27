package inflearn.DFSBFS;

import java.util.Scanner;

public class 조합수 {
    static int n;
    static int r;
    static int memory[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5 3
        n = sc.nextInt();
        r = sc.nextInt();
        memory = new int[n + 1][r + 1];

        System.out.println(DFS(n, r));
    }

    public static int DFS(int N, int R) {
        if (memory[N][R] > 0) {
            return memory[N][R];
        }
        if (N == R || R == 0) {
            return 1;
        } else {
            return memory[N][R] = DFS(N - 1, R - 1) + DFS(N - 1, R);
        }
    }
}
