package baekjoon.DFSBFS.구슬탈출4;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M][N][M];
        int rr = 0, rc = 0;
        int br = 0, bc = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    rr = i;
                    rc = j;
                }
                if (arr[i][j] == 'B') {
                    br = i;
                    bc = j;
                }
            }
        }

        System.out.println(BFS(rr, rc, br, bc));

    }

    public static int BFS(int rr, int rc, int br, int bc) {
        LinkedList<Turn> Q = new LinkedList<>();
        Q.add(new Turn(rr, rc, br, bc));
        visited[rr][rc][br][bc] = true;

        int level = 1;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Turn now = Q.poll();
                for (int j = 0; j < 4; j++) {
                    Marble nRed = move(now.rr, now.rc, 0, j);
                    Marble nBlue = move(now.br, now.bc, 0, j);

                    if (arr[nBlue.r][nBlue.c] == 'O') {
                        continue;
                    }

                    if (arr[nRed.r][nRed.c] == 'O') {
                        return level;
                    }

                    if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
                        if (nRed.dist > nBlue.dist) {
                            nRed.r -= dx[j];
                            nRed.c -= dy[j];
                        } else {
                            nBlue.r -= dx[j];
                            nBlue.c -= dy[j];
                        }
                    }

                    if (!visited[nRed.r][nRed.c][nBlue.r][nBlue.c]) {
                        visited[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;
                        Q.add(new Turn(nRed.r, nRed.c, nBlue.r, nBlue.c));
                    }
                }

            }

            level++;
        }
        return -1;
    }

    private static Marble move(int r, int c, int dist, int direction) {
        int rr = r;
        int cc = c;

        while (arr[rr + dx[direction]][cc + dy[direction]] != '#' && arr[rr][cc] != 'O') {
            dist++;
            rr += dx[direction];
            cc += dy[direction];
        }

        return new Marble(rr, cc, dist);
    }

    private static class Marble {
        int r;
        int c;
        int dist;

        public Marble(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    private static class Turn {
        int rr;
        int rc;
        int br;
        int bc;

        public Turn(int rr, int rc, int br, int bc) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
        }
    }
}
