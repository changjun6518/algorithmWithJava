package inflearn.DFSBFS;

import java.util.LinkedList;
import java.util.Scanner;

class Point {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로최단거리 {
    public static int[][] miro = new int[8][8];
    public static int[][] dis = new int[8][8];
    // 좌 상 우 하
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                miro[i][j] = sc.nextInt();
            }
        }
        miro[1][1] = 1;
        BFS(1, 1);
        if (dis[7][7] != 0) {
            System.out.println(dis[7][7]);
        } else {
            System.out.println("-1");
        }
    }

    public static void BFS(int x, int y) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && miro[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    miro[nx][ny] = 1;
                    dis[nx][ny] = dis[currentPoint.x][currentPoint.y] + 1;
                }
            }
        }
    }
}
