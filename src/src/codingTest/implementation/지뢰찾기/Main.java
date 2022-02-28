package codingTest.implementation.지뢰찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static char[][] currentMap;
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        currentMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                currentMap[i][j] = str.charAt(j);
            }
        }

        boolean mineFlag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (currentMap[i][j] == 'x' && map[i][j] == '*') {
                    mineFlag = true;
                } else if (currentMap[i][j] == 'x') {
                    currentMap[i][j] = (char) (convertNum(i, j) + '0');
                }
            }
        }
        if (mineFlag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        currentMap[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(currentMap[i][j]);
            }
            System.out.println();
        }
    }

    public static int convertNum(int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(map[nx][ny] == '.') continue;

            count++;
        }
        return count;
    }
}
