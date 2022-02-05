package codingTest.Brute_Force.피로도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A, B, C, M;
        int tiredness = 0;
        int answer = 0;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 24; i++) {
            if (tiredness + A <= M) {
                tiredness += A;
                answer += B;
            } else {
                tiredness -= C;
                if (tiredness < 0) {
                    tiredness = 0;
                }
            }
        }

        System.out.println(answer);
    }
}
