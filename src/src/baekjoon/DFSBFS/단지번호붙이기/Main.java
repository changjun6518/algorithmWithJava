package baekjoon.DFSBFS.단지번호붙이기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int area;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = scanner.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0; // 총 단지수
        ArrayList<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area = 0;
                if (map[i][j] == 1) {
                    count++;
                    DFS(i, j);
                    areaList.add(area);
                }
            }
        }

        Collections.sort(areaList);
        System.out.println(count);
        for (Integer integer : areaList) {
            System.out.println(integer);
        }
    }

    private static void DFS(int i, int j) {
        map[i][j] = 0;
        area++;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }

}
