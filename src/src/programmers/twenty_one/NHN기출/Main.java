package programmers.twenty_one.NHN기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> pQ = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    BFS(new Point(i, j));
                }
            }
        }
        Collections.sort(pQ);

        System.out.println(pQ.size());
        for (Integer count : pQ) {
            System.out.print(count + " ");
        }
    }

    public static void BFS(Point start) {
        LinkedList<Point> Q = new LinkedList<>();
        Q.add(start);
        int count = 0;
        while (!Q.isEmpty()) {
            Point now = Q.pop();
            if (arr[now.x][now.y] == 1) {
                count++;
                arr[now.x][now.y] = 0;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 0) {
                    continue;
                }

                Q.add(new Point(nx, ny));
            }
        }
        pQ.add(count);
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
