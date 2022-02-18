package codingTest.Daliy.구슬탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    static char[][] board;
    static boolean[][][][] visited;
    static int rx, ry, bx, by;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        LinkedList<Turn> Q = new LinkedList<>();
        Q.add(new Turn(rx, ry, bx, by));
        int len;
        int count = 1;
        while (!Q.isEmpty()) {
            len = Q.size();
            for (int i = 0; i < len; i++) {
                Turn now = Q.poll();
                for (int j = 0; j < 4; j++) {
                    Marble red = move(now.rx, now.ry, 0, j);
                    Marble blue = move(now.bx, now.by, 0, j);

                    if (board[blue.x][blue.y] == 'O') {
                        continue;
                    }
                    if (board[red.x][red.y] == 'O') {
                        answer = 1;
                        return;
                    }
                    if (red.x == blue.x && red.y == blue.y) {
                        if (red.dist < blue.dist) {
                            blue.x -= dx[j];
                            blue.y -= dy[j];
                        } else {
                            red.x -= dx[j];
                            red.y -= dy[j];
                        }
                    }
                    if (visited[red.x][red.y][blue.x][blue.y]) {
                        continue;
                    }
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    Q.add(new Turn(red.x, red.y, blue.x, blue.y));
                }
            }
            count++;
            if (count > 10) {
                return;
            }
        }
    }

    private static Marble move(int x, int y, int dist, int direction) {
        int nx = x;
        int ny = y;
        while (board[nx + dx[direction]][ny + dy[direction]] != '#' && board[nx][ny] != 'O') {
            nx += dx[direction];
            ny += dy[direction];
            dist++;
        }
        return new Marble(nx, ny, dist);
    }

    private static class Marble {
        int x;
        int y;
        int dist;

        public Marble(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    private static class Turn {
        int rx;
        int ry;
        int bx;
        int by;

        public Turn(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }
}
