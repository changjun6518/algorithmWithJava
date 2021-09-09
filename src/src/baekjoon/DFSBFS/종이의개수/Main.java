package baekjoon.DFSBFS.종이의개수;

import java.util.Scanner;

public class Main {
    public static int[][] paper;
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0, paper.length);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }

    public static void DFS(int r, int c, int bound) {
        if (allSameNumber(r, c, bound)) {
            if (paper[r][c] == -1) {
                minus++;
            } else if (paper[r][c] == 0) {
                zero++;
            } else {
                plus++;
            }
        } else {
            int newSize = bound / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    DFS(r + i * newSize, c + j * newSize, newSize);
                }
            }
        }
    }

    public static boolean allSameNumber(int r,int c, int bound) {
        for (int i = r; i < r + bound; i++) {
            for (int j = c; j < c + bound; j++) {
                if (paper[i][j] != paper[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
