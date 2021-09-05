package baekjoon.스택덱.크게만들기;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        int cnt = 0;
        String str = scanner.next();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int now = str.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() < now && K > cnt) {
                stack.pop();
                cnt++;
            }
            stack.add(now);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N - K; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);
    }

}
