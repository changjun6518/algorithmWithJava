package codingTest.Daliy.유닛이동시키기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int A;
    static int B;
    static int K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int endX;
    static int endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        int answer = bfs(startX, startY);
        System.out.println(answer);
    }

    private static int bfs(int startX, int startY) {
        LinkedList<Point> Q = new LinkedList<>();
        Q.add(new Point(startX, startY));
        visited[startX][startY] = true;
        int len;
        int count = 0;
        while (!Q.isEmpty()) {
            len = Q.size();
            for (int i = 0; i < len; i++) {
                Point now = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx == endX && ny == endY) return count+1;
                    if(nx<1 || ny<1 || nx>N-A+1 || ny >M-B+1) continue;
                    if (visited[nx][ny]) continue;
                    if (checkObstacle(nx,ny)) continue;

                    visited[nx][ny] = true;
                    Q.add(new Point(nx, ny));
                }
            }
            count++;
        }

        return -1;
    }

    private static boolean checkObstacle(int x, int y) {
        for (int i = x; i < x + A; i++) {
            for (int j = y; j < y + B; j++) {
                if (map[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
