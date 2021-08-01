package inflearn.DFSBFS;

import java.util.Scanner;

public class 섬나라아일랜드 {
    public static int[][] arr;
    public static int n;
    public static int[] dx = {-1, -1,0,1,1,1,0,-1};
    public static int[] dy = {0, 1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1][n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                DFS(nx, ny);
            }
        }

    }
}
//7
//1 1 0 0 0 1 0
//0 1 1 0 1 1 0
//0 1 0 0 0 0 0
//0 0 0 1 0 1 1
//1 1 0 1 1 0 0
//1 0 0 0 1 0 0
//1 0 1 0 1 0 0