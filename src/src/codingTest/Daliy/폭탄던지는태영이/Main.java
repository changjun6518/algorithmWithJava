package codingTest.Daliy.폭탄던지는태영이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int[][] map;
    static int bomb;
    static int[][] sum;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bomb = M / 2;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = bomb; i < N - bomb; i++) {
                for (int j = bomb; j < N - bomb; j++) {
                    if (go(i, j)) {
                        setBomb(i, j);
                        sum[i][j]++;
                        flag = true;
                        print();
                        System.out.println();
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.stream(sum[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    public static boolean go(int i, int j) {
        for (int k = i - bomb; k <= bomb + i; k++) {
            for (int l = j - bomb; l <= bomb + j; l++) {
                if (map[k][l] == 0) return false;
            }
        }
        return true;
    }

    public static void setBomb(int i, int j) {
        for (int k = i - bomb; k <= bomb + i; k++) {
            for (int l = j - bomb; l <= bomb + j; l++) {
                map[k][l]++;
            }
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.stream(map[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
