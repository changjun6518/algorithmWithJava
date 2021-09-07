package baekjoon.DFSBFS.숫자판점프;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] arr = new int[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<String> check = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i][j]);
                DFS(1, i, j, sb);
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int level, int a, int b, StringBuilder sb) {
        if (level == 6) {
            String result = sb.toString();
            if (!check.contains(result)) {
                check.add(result);
                answer++;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    sb.append(arr[nx][ny]);
                    DFS(level + 1, nx, ny, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }
    }
}
