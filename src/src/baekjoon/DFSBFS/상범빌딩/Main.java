package baekjoon.DFSBFS.상범빌딩;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] x = {1, -1, 0, 0, 0, 0};
    static int[] y = {0, 0, 1, -1, 0, 0};
    static int[] z = {0, 0, 0, 0, 1, -1};
    static int L;
    static int R;
    static int C;
    static Character[][][] building;
    static boolean[][][] visited;

    static class Node {
        int l;
        int r;
        int c;

        public Node(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            if(L==0 && R==0 && C==0) {
                break;
            }
            building = new Character[L][R][C];
            visited = new boolean[L][R][C];
            int l = 0, r = 0, c = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String next = scanner.next();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = next.charAt(k);
                        if (building[i][j][k] == 'S') {
                            l = i;
                            r = j;
                            c = k;
                        }
                    }
                }
            }
            int result = BFS(l, r, c);
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", result);
            }
        }
    }

    public static int BFS(int l, int r, int c) {
        LinkedList<Node> Q = new LinkedList<>();
        Q.add(new Node(l, r, c));
        int len;
        int level = 0;
        visited[l][r][c] = true;
        while (!Q.isEmpty()) {
            len = Q.size();
            level++;
            for (int i = 0; i < len; i++) {
                Node now = Q.poll();

                for (int j = 0; j < 6; j++) {
                    int nx = now.r + x[j];
                    int ny = now.c + y[j];
                    int nz = now.l + z[j];
                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < R && ny < C && nz < L && building[nz][nx][ny] == 'E') {
                        return level;
                    }
                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < R && ny < C && nz < L && building[nz][nx][ny] == '.' && !visited[nz][nx][ny]) {
                        visited[nz][nx][ny] = true;
                        Q.add(new Node(nz, nx, ny));
                    }

                }
            }
        }
        return -1;
    }
}
