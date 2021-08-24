package baekjoon.DFSBFS.영역구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int area;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();//5
        N = scanner.nextInt();//7
        K = scanner.nextInt();
        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

//        ArrayList<Integer> areaList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area = 0;
                if (map[i][j] == 0) {
                    count++;
                    DFS(i, j);
                    pq.add(area);
                }
            }
        }
//        Collections.sort(pq);
        System.out.println(count);
        for (Integer integer : pq) {
            System.out.print(integer + " ");
        }
    }

    public static void DFS(int i, int j) {
        map[i][j] = 1;
        area++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                DFS(nx, ny);
            }
        }
    }
}
