package inflearn.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class 토마토 {
    public static int[][] arr;
    public static int row, col;
    // 좌 하 우 상
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        LinkedList<Point> points = new LinkedList<>();
        arr = new int[col + 1][row + 1];
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                int status = sc.nextInt();
                arr[i][j] = status;
                if (status == 1) {
                    points.add(new Point(i, j));
                }
            }
        }

        int answer = BFS(points);

        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    public static int BFS(LinkedList<Point> queue) {
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            for (int i = 0; i < len; i++) {
                Point point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];
                    if (nx >= 1 && nx <= col && ny >= 1 && ny <= row && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return --level;
    }
}
