package codingTest.Data_Structure.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StackClass stackClass = new StackClass();
        int totalCommandCount = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= totalCommandCount; i++) {
            stackClass.execute(bf.readLine());
        }
    }

    private static class StackClass {
        private Stack<Integer> stack = new Stack<>();

        public StackClass() {
        }

        public void execute(String command) {
            if (command.startsWith("push")) {
                String[] split = command.split(" ");
                push(Integer.parseInt(split[1]));
            }

            if (command.equals("pop")) {
                pop();
            }
            if (command.equals("size")) {
                size();
            }
            if (command.equals("empty")) {
                empty();
            }
            if (command.equals("top")) {
                top();
            }
        }

        private void push(int x){
            stack.push(x);
        }

        private void pop() {
            if (stack.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.pop());
        }

        private void size() {
            System.out.println(stack.size());
        }

        private void empty() {
            if (stack.isEmpty()) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
        }

        private void top() {
            if (stack.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.peek());
        }
    }
}
