package inflearn2.DFSBFS;

import java.util.Scanner;

public class 미로탐색 {

    static int[][] miro = new int[7][7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                miro[i][j] = scanner.nextInt();
            }
        }
        miro[0][0] = 1;
        DFS(0, 0);
        System.out.println(count);
    }

    private static void DFS(int x, int y) {
        if (x == 6 && y == 6) {
            count++;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && miro[nx][ny] == 0) {
                    miro[nx][ny] = 1;
                    DFS(nx, ny);
                    miro[nx][ny] = 0;
                }
            }
        }
    }
}
