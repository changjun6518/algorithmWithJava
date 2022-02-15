package codingTest.Daliy.마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] basket = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                basket[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Wizard wizard = new Wizard(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            wizard.move(direction, size);
            wizard.fillUpWaterByCloud(basket);
            wizard.fillUpWaterByDiagonal(basket);
            wizard.seekOverTwoWater(basket);

        }

        System.out.println(wizard.sumAllWater(basket));

    }

    private static class Wizard{
        private int N;
        private List<Point> clouds;

        public Wizard(int N) {
            this.N = N;
            clouds = new ArrayList<>(List.of(
                    new Point(N, 1),
                    new Point(N, 2),
                    new Point(N - 1, 1),
                    new Point(N - 1, 2)
            ));
        }

        public void move(int direction, int count) {
            for (Point cloud : clouds) {
                cloud.x = cloud.x + dx[direction - 1] * count;
                cloud.y = cloud.y + dy[direction - 1] * count;
                while (cloud.x <= 0) {
                    cloud.x += N;
                }
                while (cloud.x > N) {
                    cloud.x -= N;
                }
                while (cloud.y <= 0) {
                    cloud.y += N;
                }
                while (cloud.y > N) {
                    cloud.y -= N;
                }
            }
        }

        public void fillUpWaterByCloud(int[][] basket) {
            for (Point cloud : clouds) {
                basket[cloud.x][cloud.y]++;
            }
        }

        public void fillUpWaterByDiagonal(int[][] basket) {
            Map<Point, Integer> map = new HashMap<>();
            for (Point waterBug : clouds) {
                int count = 0;
                for (int i = 1; i < 8; i += 2) {
                    int nx = waterBug.x + dx[i];
                    int ny = waterBug.y + dy[i];

                    if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                        continue;
                    }

                    if (basket[nx][ny] == 0) {
                        continue;
                    }

                    count++;
                }
                map.put(waterBug, count);
            }
            for (Point point : map.keySet()) {
                basket[point.x][point.y] += map.get(point);
            }
        }

        public void seekOverTwoWater(int[][] basket) {
            List<Point> duplicateCloud = new ArrayList<>(clouds);
            clouds.clear();
            boolean flag = true;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (basket[i][j] >= 2) {
                        for (Point point : duplicateCloud) {
                            if (point.same(i, j)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            clouds.add(new Point(i, j));
                            basket[i][j] -= 2;
                        }
                        flag = true;
                    }
                }
            }
        }

        public int sumAllWater(int[][] basket) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sum += basket[i][j];
                }
            }
            return sum;
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean same(int i, int j) {
            return x == i && y == j;
        }
    }
}
