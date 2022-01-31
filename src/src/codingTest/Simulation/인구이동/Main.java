package codingTest.Simulation.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int L;
    static int R;
    static int[][] country;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int flag = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        flag++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            if (flag == N * N) {
                System.out.println(answer);
                return;
            }
            answer++;
        }



    }

    public static void bfs(int x, int y) {
        LinkedList<Location> Q = new LinkedList<>();
        ArrayList<Location> union = new ArrayList<>();

        Q.add(new Location(x, y));
        int sum = 0;
        while (!Q.isEmpty()) {
            Location now = Q.pop();
            union.add(now);
            sum += country[now.x][now.y];

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx <0 ||ny<0||nx>=N||ny>=N) continue;

                if(visited[nx][ny]) continue;

                int dif = Math.abs(country[now.x][now.y] - country[nx][ny]);

                if(dif < L || dif > R) continue;

                visited[nx][ny] = true;
                Q.add(new Location(nx, ny));
            }
        }
        int avr = sum / union.size();
        for (Location location : union) {
            country[location.x][location.y] = avr;
        }
    }

    private static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//2 40 50
//50 30
//20 40