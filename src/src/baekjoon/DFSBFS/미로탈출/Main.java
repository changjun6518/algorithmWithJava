package baekjoon.DFSBFS.미로탈출;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static Sign[][] arr;
    static boolean[][] visited;
    static boolean[][] possible;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new Sign[N][M];
        for (int i = 0; i < N; i++) {
            String next = scanner.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Sign.parse(next.charAt(j));
            }
        }
        visited = new boolean[N][M];
        possible = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!possible[i][j]) {
                    possible[i][j] = DFS(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (possible[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static boolean DFS(int x, int y) {
        Sign now = arr[x][y];
        int nx = x + now.x;
        int ny = y + now.y;

        if (nx < 0 || nx >= N || ny < 0 || ny >= M || possible[nx][ny]) {
            return true;
        }

        if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            possible[nx][ny] = DFS(nx, ny);
            visited[nx][ny] = false;

            if (possible[nx][ny]) {
                return true;
            }
        }
        return false;
    }

}

enum Sign {
    U(-1, 0,'U'),
    R(0, 1,'R'),
    D(1, 0,'D'),
    L(0, -1,'L'),
    ;

    int x;
    int y;
    Character represent;

    Sign(int x, int y, Character represent) {
        this.x = x;
        this.y = y;
        this.represent = represent;
    }

    public static Sign parse(Character represent) {
        return Arrays.stream(Sign.values()).filter(sign -> sign.represent == represent).findFirst().get();
    }
}
