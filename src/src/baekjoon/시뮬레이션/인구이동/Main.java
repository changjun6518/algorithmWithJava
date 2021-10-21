package baekjoon.시뮬레이션.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int N;
    static int L;
    static int R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 되는 것들을 싹다 넣고 이어가면서 싹다 넣고 더 이상 없으면 갯수로 나눠 넣기
        // 방문으로 체크
        int count = 0;

        while (true) {
            if (check()) {
                break;
            } else count++;
        }
        System.out.println(count);

    }

    // 인원 이동이 있을까?
    // 전체 체크
    public static boolean check() {
        boolean[][] visited = new boolean[N][N];
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ArrayList<Point> list = new ArrayList<>();
                    list.add(new Point(i, j));
                    int sum = solution(i, j, visited, list);
                    if (list.size() > 1) {
                        change(sum, list);
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    private static void change(int sum, ArrayList<Point> list) {
        int avg = sum / list.size();
        for (Point point : list) {
            A[point.x][point.y] = avg;
        }
    }

    public static int solution(int i, int j, boolean[][] visited, ArrayList<Point> list) {
        visited[i][j] = true;
        int sum = A[i][j];
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }

            int d = Math.abs(A[i][j] - A[nx][ny]);
            if (d >= L && d <= R) {
                list.add(new Point(nx, ny));
                sum += solution(nx, ny, visited, list);
            }
        }
        return sum;
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
