package codingTest.Backtracking.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                arr[level] = i + 1;
                dfs(level + 1);
            }
        }
    }
}
