package codingTest.implementation.최소최대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            LinkedList<Integer> Q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                max = Math.max(max, number);
                min = Math.min(min, number);
            }

            System.out.println(min + " " + max);

        }
    }
}
