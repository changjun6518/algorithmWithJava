package codingTest.Daliy.모래성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map = new char[N][M];
        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '.') {
                    Q.add(new Point(i, j));
                }
            }
        }
        int len;
        int answer = 0;
        while (!Q.isEmpty()) {
            answer++;
            len = Q.size();
            for (int i = 0; i < len; i++) {
                Point point = Q.poll();
                point.wave(N, M, map, Q);
            }
        }

        System.out.println(answer - 1);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void wave(int N, int M, char[][] map, Queue<Point> Q) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0||ny<0||nx>=N||ny>=M) continue;

                if (map[nx][ny] == '.' || map[nx][ny] == '9') continue;

                map[nx][ny]--;

                if (map[nx][ny] == '0') {
                    map[nx][ny] = '.';
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }
}
