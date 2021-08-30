package baekjoon.DFSBFS.사다리조작;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][] ladder;
    static int answer = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 가로 선
        M = scanner.nextInt(); // 연결된 가로선 개수
        H = scanner.nextInt(); // 세로 층
        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ladder[a][b] = 1;
            ladder[a][b + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            DFS(0, i);
            if (flag) {
                break;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }

    static void DFS(int addLine, int size) {
        if (addLine == size) {
            if (checkLadder()) {
                answer = Integer.min(answer, addLine);
                flag = true;
            }
        } else {
            for (int j = 1; j < N; j++) {
                for (int i = 1; i <= H; i++) {
                    if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                        ladder[i][j] = 1;
                        ladder[i][j + 1] = 2;
                        DFS(addLine + 1, size);
                        ladder[i][j] = 0;
                        ladder[i][j + 1] = 0;
                    }
                }
            }
        }
    }

    static boolean checkLadder() {

        for (int j = 1; j <= N; j++) {
            int point = j;
            for (int i = 1; i <= H; i++) {
                if (ladder[i][point] == 1) {
                    point++;
                }
                else if (ladder[i][point] == 2) {
                    point--;
                }
            }
            if (point != j) {
                return false;
            }
        }
        return true;
    }

}
