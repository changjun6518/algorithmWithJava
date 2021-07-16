package inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        352+*9-

        String input = sc.next();
        Stack<Integer> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else {
                    stack.push(lt / rt);
                }
            }
        }
        System.out.println(stack.get(0));

    }
}
