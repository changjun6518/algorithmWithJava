package baekjoon.DFSBFS.로봇청소기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int w;
    static int h;
    static Character[][] arr;
    static ArrayList<Position> dirty;
    static int[][] distance;
    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        check: while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            answer = Integer.MAX_VALUE;
            if (w == 0 && h == 0) {
                break;
            }
            arr = new Character[w][h];
            dirty = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                String next = scanner.next();
                for (int j = 0; j < w; j++) {
                    arr[j][i] = next.charAt(j);
                    if (arr[j][i] == 'o') {
                        dirty.add(0, new Position(j, i));
                    } else if (arr[j][i] == '*') {
                        dirty.add(new Position(j, i));
                    }
                }
            }
            distance = new int[dirty.size()][dirty.size()];
            for (int i = 0; i < dirty.size() - 1; i++) {
                for (int j = i + 1; j < dirty.size(); j++) {
                    int result = BFS(dirty.get(i), dirty.get(j));
                    if (result == -1) {
                        System.out.println(-1);
                        continue check;
                    }
                    distance[i][j] = distance[j][i] = result;
                }
            }

            int[] order = new int[dirty.size()];
            boolean[] visit = new boolean[dirty.size()];
            DFS(1, order, visit);


            System.out.println(answer);
        }

    }

    public static int BFS(Position start, Position target) {
        LinkedList<Position> Q = new LinkedList<>();
        boolean[][] visited = new boolean[w][h];
        Q.add(start);
        visited[start.x][start.y] = true;

        int count = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Position now = Q.poll();
                if (now.x == target.x && now.y == target.y) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                        continue;
                    }
                    if (visited[nx][ny] || arr[nx][ny] == 'x') {
                        continue;
                    }

                    Q.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            count++;
        }
        return -1;
    }

    public static void DFS(int depth, int[] order, boolean[] visit) {
        if (depth == dirty.size()) {
            int sum = 0;
            for (int i = 0; i < dirty.size() - 1; i++) {
                sum += distance[order[i]][order[i + 1]];
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = 1; i < dirty.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    order[depth] = i;
                    DFS(depth + 1, order, visit);
                    visit[i] = false;
                }
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
