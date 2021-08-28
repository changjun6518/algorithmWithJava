package baekjoon.DFSBFS.스타트와링크;

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int sum;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int current = scanner.nextInt();
                arr[i][j] = current;
                sum += current;
            }
        }

        DFS(0, 0);
        System.out.println(answer);

    }

    public static void DFS(int level, int index) {
        if (level == N / 2) {
            // 조합이 완성 되었을 때
            calculate();
            return;
//  조합 경우의 수 대로 능력치 하나씩 쌓아가고 싶은데
            // 아니면 끝에서라도 다 계산하는 방법이 떠오르지가 않아
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(level + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    public static void calculate() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += arr[i][j];
                    teamStart += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += arr[i][j];
                    teamLink += arr[j][i];

                }
            }
        }


        int temp = Math.abs(teamLink - teamStart);
        answer = Math.min(temp, answer);
    }
}
