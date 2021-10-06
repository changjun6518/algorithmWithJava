package baekjoon.DFSBFS.로봇;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] arr;
    static int M;
    static int N;
    static location start;
    static location target;

    public static void main(String[] args) {
        // 일단 BFS 로 풀고
        // x, y, 방향 을 담는 클래스 만들고
        // queue에 넣어서 최단 거리 만날 때까지 진행
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        start = new location(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        target = new location(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        System.out.println(BFS());
    }

    private static int BFS() {
        LinkedList<location> Q = new LinkedList<>();
        Q.add(start);
        boolean[][][] visited = new boolean[M + 1][N + 1][5];
        int moveCount = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                location now = Q.poll();

                if (now.y == target.y && now.x == target.x && now.dir == target.dir) {
                    return moveCount;
                }

                for (int j = 1; j <= 3; j++) {
                    int ny = now.y + dy[now.dir - 1] * j;
                    int nx = now.x + dx[now.dir - 1] * j;
                    if (nx <= 0 || ny <= 0 || nx > N || ny > M) break;

                    if(arr[ny][nx] == 1) break;

                    if (visited[ny][nx][now.dir]) {
                        continue;
                    } else {
                        visited[ny][nx][now.dir] = true;
                        Q.add(new location(ny, nx, now.dir));
                    }
                }

                // 회전 했을 때 Q에 넣기
                int left = 0, right = 0;
                switch (now.dir) {
                    case 1 : {
                        left = 3;
                        right = 4;
                        break;
                    }
                    case 2 : {
                        left = 3;
                        right = 4;
                        break;
                    }
                    case 3:
                        left = 1;
                        right = 2;
                        break;
                    case 4:
                        left = 1;
                        right = 2;
                        break;
                }
                if (!visited[now.y][now.x][left]) {
                    visited[now.y][now.x][left] = true;
                    Q.add(new location(now.y, now.x, left));
                }
                if (!visited[now.y][now.x][right]) {
                    visited[now.y][now.x][right] = true;
                    Q.add(new location(now.y, now.x, right));
                }
            }
            moveCount++;
        }
        return 0;
    }

    private static class location {
        int y;
        int x;
        int dir;

        public location(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
