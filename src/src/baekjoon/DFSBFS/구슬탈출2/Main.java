package baekjoon.DFSBFS.구슬탈출2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    static int N;
    static int M;
    static Character[][] arr;
    static boolean[][][][] visited;
    static int ri, rj, bi, bj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new Character[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String next = scanner.next();
            for (int j = 0; j < M; j++) {
                char c = next.charAt(j);
                arr[i][j] = c;
                if (c == 'R') {
                    ri = i;
                    rj = j;
                }
                if (c == 'B') {
                    bi = i;
                    bj = j;
                }
            }
        }


        System.out.print(BFS());

    }

    public static int BFS() {
        LinkedList<Turn> q = new LinkedList<>();
        int level = 1;
        q.add(new Turn(ri, rj, bi, bj));
        visited[ri][rj][bi][bj] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Turn now = q.poll();
                for (int j = 0; j < 4; j++) {
                    Marble nRed = move(now.ri, now.rj, 0, j);
                    Marble nBlue = move(now.bi, now.bj, 0, j);

                    if (arr[nBlue.r][nBlue.c] == 'O') {
                        continue;
                    }
                    if (arr[nRed.r][nRed.c] == 'O') {
                        return level;
                    }

                    if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
                        if (nRed.dist > nBlue.dist) {
                            nRed.r -= x[j];
                            nRed.c -= y[j];
                        } else {
                            nBlue.r -= x[j];
                            nBlue.c -= y[j];
                        }
                    }

                    if (visited[nRed.r][nRed.c][nBlue.r][nBlue.c]) {
                        continue;
                    }

                    visited[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;
                    q.add(new Turn(nRed.r, nRed.c, nBlue.r, nBlue.c));
                }
            }
            if (++level > 10) {
                return -1;
            }
        }
        return -1;
    }

    private static Marble move(int r, int c, int dist, int d) {
        int rr = r, cc = c;
        while (arr[rr + x[d]][cc + y[d]] != '#' && arr[rr][cc] != 'O') {
            rr += x[d];
            cc += y[d];
            dist++;
        }
        return new Marble(rr, cc, dist);
    }

    static class Marble {
        int r, c, dist;

        public Marble(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static class Turn {
        int ri, rj, bi, bj;

        public Turn(int ri, int rj, int bi, int bj) {
            this.ri = ri;
            this.rj = rj;
            this.bi = bi;
            this.bj = bj;
        }
    }
}
