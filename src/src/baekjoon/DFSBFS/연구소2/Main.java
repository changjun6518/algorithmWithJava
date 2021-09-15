package baekjoon.DFSBFS.연구소2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Virus> viri = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;


    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 2) {
                    viri.add(new Virus(i, j));
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
            ArrayList<Integer> cases = new ArrayList<>();
            for (int i = 0; i < viri.size(); i++) {
                if (visited[i]) {
                    cases.add(i);
                }
            }
            int result = BFS(cases);
            if (result == -1) {
                return;
            }
            answer = Math.min(answer, result);
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

    public static int BFS(ArrayList<Integer> cases) {
        LinkedList<Virus> Q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        for (Integer virusLocation : cases) {
            Virus virus = viri.get(virusLocation);
            visit[virus.x][virus.y] = true;
            Q.add(virus);
        }
        int level = 0;
        if (check(visit)) {
            return level;
        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Virus now = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == 2)) {
                        visit[nx][ny] = true;
                        Q.add(new Virus(nx, ny));
                    }
                }
            }
            level++;
            if (check(visit)) {
                return level;
            }
        }

        return -1;
    }

    public static boolean check(boolean[][] visit) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && (map[i][j] == 0 || map[i][j] == 2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
