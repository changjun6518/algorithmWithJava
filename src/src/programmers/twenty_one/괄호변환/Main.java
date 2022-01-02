package programmers.twenty_one.괄호변환;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.next()));

    }

    public static String solution(String p) {
        if (p.equals("")) {
            return "";
        }

        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder(p);
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int open = 0;
        int close = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                open++;
            }
            if (sb.charAt(i) == ')') {
                close++;
            }
            if (open == close) {
                u.append(sb.substring(0, i + 1));
                v.append(sb.substring(i + 1));
                break;
            }
        }

        if (isCorrect(u.toString())) {
            return u.append(solution(v.toString())).toString();
        }

        answer.append("(").append(solution(v.toString())).append(")");
        u.deleteCharAt(0);
        u.deleteCharAt(u.length() - 1);
        answer.append(swap(u.toString()));
        return answer.toString();

    }

    public static boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.size() < 1;
    }


    public static String swap(String u) {
        StringBuilder sw = new StringBuilder();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                sw.append(')');
            }
            if (c == ')') {
                sw.append('(');
            }
        }
        return sw.toString();
    }
}
