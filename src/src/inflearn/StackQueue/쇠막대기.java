package inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ()(((()())(())()))(())

        // ()이면 레이저 count ++
        // (는 stack에 푸시
        // ) 만나면 stack에서 팝하고 레이저 카운트 된거 +1 해서 answer ++
        // stack이 empty면 레이저 count reset = 0

        String input = sc.next();
        Stack<Character> stack = new Stack<>();

        char[] inputArray = input.toCharArray();
        int answer = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '(') {
                stack.push(inputArray[i]);
            } else {
                if (inputArray[i - 1] == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
