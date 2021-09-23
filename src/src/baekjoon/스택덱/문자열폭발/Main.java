package baekjoon.스택덱.문자열폭발;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        mirkovC4nizCC44
//C4
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String bomb = sc.next();

        String solution = solution(str, bomb);

        if (solution == null) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(solution);


    }

    public static String solution(String str, String bomb) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        for (int i = 0; i < str.length() - bomb.length(); i++) {
            String checkBomb = str.substring(i, i + bomb.length());
            if (checkBomb.equals(bomb)) {
                i = i + bomb.length()-1;
                count++;
                continue;
            }
            sb.append(str.charAt(i));
        }
        for (int i = str.length() - bomb.length() + 1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }


        if (count == 0) {
            return sb.toString();
        }

        return solution(sb.toString(), bomb);
    }

}
