package baekjoon.시뮬레이션.경사로;

import java.util.Scanner;

public class Main {
    static int N;
    static int L;
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

//        6 2
//3 3 3 3 3 3
//2 3 3 3 3 3
//2 2 2 3 2 3
//1 1 1 2 2 2
//1 1 1 3 3 1
//1 1 2 3 3 2
        //경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
        //낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
        //경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.

//경사로를 놓은 곳에 또 경사로를 놓는 경우
//낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
//낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
//경사로를 놓다가 범위를 벗어나는 경우
        for (int i = 0; i < N; i++) {
            if (check(i, 0, 0)) {
                count++;
            }

            if (check(0, i, 1)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean check(int x, int y, int d) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for (int j = 0; j < N; j++) {
            height[j] = (d == 0) ? arr[x][y + j] : arr[x + j][y];
        }
        for (int i = 0; i < N - 1; i++) {
            if (height[i] == height[i + 1]) {
                continue;
            }

            if (Math.abs(height[i] - height[i + 1]) > 1) {
                return false;
            }

            if (height[i] - 1 == height[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || height[i + 1] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (height[i] + 1 == height[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
