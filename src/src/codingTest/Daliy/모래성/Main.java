package codingTest.Daliy.모래성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[N][M];
        LinkedList<Location> needToValidateLocations = new LinkedList<>();
        Stack<Location> needToUpdateLocations = new Stack<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            String[] str = stringTokenizer.nextToken().split("");
            for (int j = 0; j < M; j++) {
                if (str[j].equals(".")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(str[j]);
                    if (map[i][j] != 9) {
                        needToValidateLocations.add(new Location(i, j));
                    }
                }
            }
        }
        int len;
        int answer = 0;
        while (true) {
            len = needToValidateLocations.size();
            for (int i = 0; i < len; i++) {
                Location location = needToValidateLocations.pop();
                if (location.check(map)) {
                    needToUpdateLocations.add(location);
                } else {
                    needToValidateLocations.add(location);
                }
            }

            if (needToUpdateLocations.isEmpty()) {
                break;
            }

            while (!needToUpdateLocations.isEmpty()) {
                Location location = needToUpdateLocations.pop();
                map[location.x][location.y] = 0;
            }

            answer++;
        }


        System.out.println(answer);
    }

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean check(int[][] map) {
            int zeroCount = 0;
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (map[nx][ny] == 0) {
                    zeroCount++;
                    if (map[x][y] <= zeroCount) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
