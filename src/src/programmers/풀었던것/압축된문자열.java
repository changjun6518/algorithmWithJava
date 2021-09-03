package programmers.풀었던것;

import java.util.Scanner;
import java.util.Stack;

public class 압축된문자열 {
    public static void main(String[] args) {
//        "2(3(hi)co)"	"hihihicohihihico"

        Scanner sc = new Scanner(System.in);
        String compress = sc.next();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compress.length(); i++) {
            if (Character.isDigit(compress.charAt(i))) {
                stack.push(compress.charAt(i));
            } else if (compress.charAt(i) == '(') {
                stack.push(compress.charAt(i));
            } else {
                while (stack.peek() == '(') {
                    sb.append(stack.pop());
                }
                StringBuilder temp = sb.reverse();
                Character num = stack.pop();
                Integer numInt = Integer.valueOf(num);
                sb.delete(0, sb.length());
                for (int j = 0; j < numInt; j++) {
                    sb.append(temp);
                }
            }
        }
    }
}
