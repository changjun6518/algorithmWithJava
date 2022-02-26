package codingTest.Daliy.원판돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x, d, k;
        int index;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            index = x;
            while (index <= N) {
                rotate(index, d, k);
                index += x;

            }
            remove();
        }

        System.out.println(sum());
    }

    private static int sum() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    private static void remove() {
        LinkedList<int[]> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (ny > M) {
                        ny -= M;
                    } else if (ny <= 0) {
                        ny += M;
                    }

                    if (nx <= 0 || nx > N) {
                        continue;
                    }
                    if(arr[nx][ny] == 0) continue;

                    if(arr[nx][ny] != arr[i][j]) continue;

                    int[] temp = {i, j};
                    Q.add(temp);
                }
            }
        }
        if (Q.isEmpty()) {
            average();
        }

        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            arr[poll[0]][poll[1]] = 0;
        }
    }

    private static void average() {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }
        float avr = (float) sum / count;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][j] < avr) {
                        arr[i][j]++;
                    } else if (arr[i][j] > avr) {
                        arr[i][j]--;
                    }
                }
            }
        }
    }

    private static void rotate(int x, int d, int k) {
        int[] temp = new int[M + 1];
        int count = k % M;
        if (d == 1) {
            count = M - count;
        }
        for (int i = 1; i <= M; i++) {
            int index = i - count;
            if (index <= 0) {
                index += M;
            }
            temp[i] = arr[x][index];
        }
        for (int i = 1; i <= M; i++) {
            arr[x][i] = temp[i];
        }
    }
}
