package baekjoon.스택덱.쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Stack<Character> stack = new Stack<>();
        int barCount = 0;
        int laserCount = 0;
        int answer = 0;
        stack.push('(');
        for (int i = 1; i < next.length(); i++) {
            char now = next.charAt(i);
            char post = next.charAt(i - 1);
            if (now == '(') {
                stack.push(now);
            }
            if (now == ')') {
                stack.pop();
                if (post == '(') {
                    answer += stack.size();
                }
                if (post == ')') {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

}
