package baekjoon.DFSBFS.알파벳;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int R;
    static int C;
    static char arr[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] visited;
    static Stack<Character> checkDuplicate;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        arr = new char[R][C];
        visited = new boolean[26];
        checkDuplicate = new Stack<>();

        for (int i = 0; i < R; i++) {
            String str = scanner.next();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[arr[0][0] - 'A'] = true;
        checkDuplicate.add(arr[0][0]);
        DFS(0, 0, 1);

        System.out.println(answer);
    }

    private static void DFS(int r, int c, int d) {

        answer = Math.max(answer, d);

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x >= 0 && x < R && y >= 0 && y < C && !visited[arr[x][y]-'A']) {
                visited[arr[x][y] - 'A'] = true;
                DFS(x, y, d + 1);
                visited[arr[x][y] - 'A'] = false;
            }
        }
    }
}
