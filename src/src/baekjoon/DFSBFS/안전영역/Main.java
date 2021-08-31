package baekjoon.DFSBFS.안전영역;

import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        int max = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int now = scanner.nextInt();
                map[i][j] = now;
                max = Math.max(now, max);
            }
        }

        for (int i = 0; i < max; i++) {
            visited = new boolean[N][N];
            int solution = solution(i);
            answer = Math.max(answer, solution);
        }

        System.out.println(answer);

    }

    public static int solution(int height) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > height && !visited[i][j]) {
                    result++;
                    count(i, j, height);
                }
            }
        }
        return result;
    }

    public static void count(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > height && !visited[nx][ny]) {
                count(nx, ny, height);
            }
        }
    }

}
