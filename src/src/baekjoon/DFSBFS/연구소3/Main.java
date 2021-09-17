package baekjoon.DFSBFS.연구소3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static ArrayList<Position> viri = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    viri.add(new Position(i, j));
                }
            }
        }
        visited = new boolean[viri.size()];

        DFS(0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static void DFS(int level) {
        if (level == M) {
            ArrayList<Integer> virusIndex = new ArrayList<>();
            for (int i = 0; i < viri.size(); i++) {
                if (visited[i]) {
                    virusIndex.add(i);
                }
            }
            int result = BFS(virusIndex);
            if (result != -1) {
                answer = Math.min(result, answer);
            }

        } else {
            for (int i = level; i < viri.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static int BFS(ArrayList<Integer> virusIndex) {
        LinkedList<Position> Q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        int[][] dis = new int[N][N];
        for (Integer i : virusIndex) {
            Position position = viri.get(i);
            Q.add(position);
            visit[position.x][position.y] = true;
            dis[position.x][position.y] = 0;
            activate(position, visit);
        }

        int res = check(visit, dis);
        if (res != -1) {
            return res;
        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Position now = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        dis[nx][ny] = dis[now.x][now.y] + 1;
                        Position next = new Position(nx, ny);
                        activate(next, visit);
                        Q.add(next);
                    }
                }
            }
        }

        res = check(visit, dis);
        if (res != -1) {
            return res;
        }

        return -1;
    }

    public static int check(boolean[][] visit, int[][] dis) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1) {
                    if (!visit[i][j]) {
                        return -1;
                    }
                    max = Math.max(max, dis[i][j]);
                }

            }
        }
        return max;
    }

    public static void activate(Position position, boolean[][] visit) {
        for (int i = 0; i < 4; i++) {
            int nx = position.x + dx[i];
            int ny = position.y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 2 && !visit[nx][ny]) {
                visit[nx][ny] = true;
                activate(new Position(nx, ny), visit);
            }
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
