package baekjoon.DFSBFS.로봇청소기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int w;
    static int h;
    static Character[][] arr;
    static int dirtyCount = 0;
    static ArrayList<Location> dirtyList;

    public static void main(String[] args) {
        // 갯수 카운트 해서 종료 하는 걸로
        // 방문 처리도 해야겠는데
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextInt();
        h = scanner.nextInt();
        int startR = 0;
        int startC = 0;
        arr = new Character[h][w];
        dirtyList = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            String next = scanner.next();
            for (int j = 0; j < w; j++) {
                arr[i][j] = next.charAt(j);
                if (arr[i][j] == '*') {
                    dirtyList.add(new Location(i, j));
                } else if (arr[i][j] == 'o') {
                    dirtyList.add(0, new Location(i, j));
                }
            }
        }

    }

    private static int BFS(int startR, int startC) {
        LinkedList<Location> Q = new LinkedList<>();
        Q.add(new Location(startR, startC));

        boolean[][] visited = new boolean[h][w];
        int count = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Location nowRobot = Q.poll();
                if (dirtyCount == 0) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = nowRobot.row + dx[j];
                    int ny = nowRobot.col + dy[j];

                    if(nx<0||ny<0||nx>=h||ny>=w) continue;

                    if(visited[nx][ny]) continue;

                    if(arr[nx][ny] == 'X') continue;

                    if (arr[nx][ny] == '*') {
                        dirtyCount--;
                        arr[nx][ny] = '.';
                    }

                    visited[nx][ny] = true;
                    Q.add(new Location(nx, ny));

                }
                count++;
            }
        }

        return -1;
    }

    private static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
