package inflearn.DFSBFS;

import java.util.Scanner;

public class 미로탐색 {
    public static int[][] miro = new int[9][9];
    // 좌 상 우 하
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            miro[0][i] = 1;
            miro[i][0] = 1;
            miro[8][i] = 1;
            miro[i][8] = 1;
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                miro[i][j] = sc.nextInt();
            }
        }
        miro[1][1] = 1;
        DFS(1,1);
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        if (x == 7 && y ==7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (miro[nx][ny] == 0) {
                    miro[nx][ny] = 1;
                    DFS(nx, ny);
                    miro[nx][ny] = 0;
                }
            }
        }
    }
}
//0 0 0 0 0 0 0
//0 1 1 1 1 1 0
//0 0 0 1 0 0 0
//1 1 0 1 0 1 1
//1 1 0 0 0 0 1
//1 1 0 1 1 0 0
//1 0 0 0 0 0 0