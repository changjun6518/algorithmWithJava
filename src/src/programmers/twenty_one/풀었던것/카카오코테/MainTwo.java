package programmers.twenty_one.풀었던것.카카오코테;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        System.out.println(solution(11001100, 7));
        System.out.println(solution(437674, 3));
//        System.out.println(solution(999999, 8));

    }


    public static int solution(int n, int k) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            answer.insert(0, (n % k));
            n /= k;
        }
        String str = answer.toString();

        int startIndex = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                String substring = str.substring(startIndex, i);
                if (isPrime(substring)) {
                    result++;
                }
                startIndex = i+1;
            }
            if (i == str.length() - 1) {
                if (startIndex <= str.length() - 1) {
                    String substring = str.substring(startIndex);
                    if (isPrime(substring)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    // 바로 0이라면?
    public static boolean isPrime(String numStr) {
        if (numStr.equals("") || numStr.equals("1") || numStr.equals("0")) {
            return false;
        }

        int num = Integer.valueOf(numStr);
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
