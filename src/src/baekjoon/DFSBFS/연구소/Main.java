package baekjoon.DFSBFS.연구소;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int N;
    public static int M;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        DFS(0, arr);

        System.out.println(answer);
    }

    public static void DFS(int level, int[][] arr) {
        if (level == 3) {
            // 2로 채우고 0개수 찾기
            answer = Math.max(answer, check(arr));
        } else {
            // 1 세팅하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1;
                        DFS(level + 1, arr);
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    public static int check(int[][] arr) {
        boolean[][] visited = new boolean[N][M];
        LinkedList<Position> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    Q.add(new Position(i, j));
                    visited[i][j] = true;
                }
                if (arr[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            Position now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.a + dx[i];
                int ny = now.b + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.add(new Position(nx, ny));
                }
            }
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static class Position {
        int a;
        int b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
