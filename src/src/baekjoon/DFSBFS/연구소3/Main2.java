package baekjoon.DFSBFS.연구소3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Virus> viri = new ArrayList<>();
    static Virus[] initVirus;
    static int originEmptyCount = 0;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][N];
        initVirus = new Virus[M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 2) {
                    viri.add(new Virus(i, j, 0));
                }
                else if (map[i][j] == 0) {
                    originEmptyCount++;
                }
            }
        }


        if (originEmptyCount == 0) {
            System.out.println(0);
        } else {
            DFS(0, 0);
            result = result == Integer.MAX_VALUE ? -1 : result;
            System.out.println(result);
        }

    }

    // virus를 M개 선택하기 위한 조합 구하기
    public static void DFS(int level, int selectCount) {
        if (selectCount == M) {
            BFS(originEmptyCount);
        } else {
            for (int i = level; i < viri.size(); i++) {
                initVirus[selectCount] = viri.get(i);
                DFS(i + 1, selectCount + 1);
            }
        }
    }

    // virus를 퍼트리기 위한 함수
    public static void BFS(int emptyCount) {
        LinkedList<Virus> Q = new LinkedList<>();
        boolean[][] visitedVirus = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            Q.add(initVirus[i]);
            visitedVirus[initVirus[i].x][initVirus[i].y] = true;
        }

        while (!Q.isEmpty()) {
            Virus now = Q.poll();
            for (int j = 0; j < 4; j++) {

                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visitedVirus[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    emptyCount--;
                }

                if (emptyCount == 0) {
                    result = Math.min(result, now.time + 1);
                    return;
                }
                Q.add(new Virus(nx, ny, now.time + 1));
                visitedVirus[nx][ny] = true;

            }

        }

    }


    private static class Virus {
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
