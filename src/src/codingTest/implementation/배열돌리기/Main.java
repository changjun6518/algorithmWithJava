package codingTest.implementation.배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (degree > 0) {
                for (int j = 0; j < degree / 45; j++) {
                    rotate(arr, N);
                }
            } else {
                for (int j = 0; j < -degree / 45; j++) {
                    rotateReverse(arr, N);
                }
            }

            for (int j = 0; j < N; j++) {
                String row = Arrays.stream(arr[j])
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
                System.out.println(row);
            }
        }
    }

    public static void rotate(int[][] arr, int N) {
        int[] temp = new int[N];
        // 주대각선 -> 가운데 열
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i][N/2];
            arr[i][N/2] = arr[i][i];
        }
        // 가운데 열 -> 부대각선
        int[] temp2 = new int[N];
        for (int i = 0; i < N; i++) {
            temp2[i] = arr[i][N - i -1];
            arr[i][N - i-1] = temp[i];
        }
        // 부대각선 -> 가운데 행
        for (int i = 0; i < N; i++) {
            temp[i] = arr[N / 2][i];
            arr[N / 2][i] = temp2[N - i - 1];
        }
        // 가운데 행 -> 주대각선
        for (int i = 0; i < N; i++) {
            arr[i][i] = temp[i];
        }
    }

    public static void rotateReverse(int[][] arr, int N) {
        int[] temp = new int[N];
        // 부대각선 -> 가운데 열
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i][N/2];
            arr[i][N/2] = arr[i][N - i-1];
        }
        // 가운데 열 -> 주대각선
        int[] temp2 = new int[N];
        for (int i = 0; i < N; i++) {
            temp2[i] = arr[i][i];
            arr[i][i] = temp[i];
        }
        // 주대각선 -> 가운데 행
        for (int i = 0; i < N; i++) {
            temp[i] = arr[N / 2][i];
            arr[N / 2][i] = temp2[i];
        }
        // 가운데 행 -> 부대각선
        for (int i = 0; i < N; i++) {
            arr[N - i-1][i] = temp[i];
        }
    }

}
