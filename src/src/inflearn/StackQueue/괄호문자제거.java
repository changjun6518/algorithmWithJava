package inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {

                }
            } else {
                stack.push(c);
            }
        }

        for (Character c : stack) {
            System.out.print(c);
        }
        System.out.println(stack.get(1));
    }
//    (A(BC)D)EF(G(H)(IJ)K)LM(N)
}
