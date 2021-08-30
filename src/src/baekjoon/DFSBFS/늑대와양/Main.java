package baekjoon.DFSBFS.늑대와양;

import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R;
    static int C;
    static Character[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        map = new Character[R][C];
        for (int i = 0; i < R; i++) {
            String next = scanner.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = next.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'W') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            if (map[nx][ny] == '.') {
                                map[nx][ny] = 'D';
                            }
                            if (map[nx][ny] == 'S') {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(1);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
