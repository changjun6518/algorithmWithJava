package baekjoon.스택덱.문자열폭발;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String bomb = sc.next();

        String solution = solution(str, bomb);
        String result = solution.length() == 0 ? "FRULA" : solution;
        System.out.println(result);

    }

    public static String solution(String str, String bomb) {
        char[] result = new char[str.length()];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            result[idx] = str.charAt(i);
            if (checkBomb(result, idx, bomb)) {
                idx -= bomb.length();
            }
            idx++;
        }
        return String.valueOf(result, 0, idx);
    }

    public static boolean checkBomb(char[] result, int idx, String bomb) {
        if (idx - bomb.length() + 1 < 0) {
            return false;
        }
        for (int i = 0; i < bomb.length(); i++) {
            if (bomb.charAt(i) != result[idx - bomb.length() + 1 + i]) {
                return false;
            }
        }
        return true;
    }
}
