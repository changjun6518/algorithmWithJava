package codingTest.implementation.빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Point> map = new HashMap<>();
    static boolean[][] visited = new boolean[6][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
            }
        }
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer++;
                Point point = map.get(Integer.parseInt(st.nextToken()));
                point.erase();
                if (bingo()) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    private static int countRow(int i) {
        for (int j = 1; j <= 5; j++) {
            if (!visited[i][j]) {
                return 0;
            }
        }
        return 1;
    }

    private static int countColumn(int j) {
        for (int i = 1; i <= 5; i++) {
            if (!visited[i][j]) {
                return 0;
            }
        }
        return 1;
    }

    private static int countDiagonal() {
        for (int i = 1; i <= 5; i++) {
            if (!visited[i][i]) {
                return 0;
            }
        }
        return 1;
    }

    private static int countReverseDiagonal() {
        for (int i = 1; i <= 5; i++) {
            if (!visited[i][6 - i]) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean bingo() {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            count += countRow(i);
            count += countColumn(i);
        }
        count += countDiagonal();
        count += countReverseDiagonal();
        return 3 <= count;
    }
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void erase() {
            visited[x][y] = true;
        }
    }

}
