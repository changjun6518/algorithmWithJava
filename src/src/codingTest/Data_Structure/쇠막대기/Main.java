package codingTest.Data_Structure.쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parentheses = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char prev = '(';
        for (char c : parentheses.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (prev == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    count++;
                    stack.pop();
                }
            }
            prev = c;
        }

        System.out.println(count);
    }
}