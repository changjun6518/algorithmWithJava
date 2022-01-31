package codingTest.Graph_Traversal.미로탐색;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] miro;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        miro = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] row = sc.next().split("");
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        System.out.println(bfs() + 1);

    }

    private static int bfs() {
        LinkedList<int[]> Q = new LinkedList<>();
        int[] start = new int[]{1, 1};
        Q.add(start);
        visited[1][1] = true;
        int len;
        int count = 0;
        while (!Q.isEmpty()) {
            len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] now = Q.pop();
                for (int j = 0; j < 4; j++) {
                    if(now[0] == N && now[1] == M) return count;

                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];


                    if(nx<1||ny<1||nx>N||ny>M) continue;

                    if (miro[nx][ny] == 0 || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    int[] next = new int[]{nx, ny};
                    Q.add(next);
                }
            }

            count++;
        }
        return count;
    }
}
