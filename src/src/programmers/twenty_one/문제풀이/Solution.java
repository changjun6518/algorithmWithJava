package programmers.twenty_one.문제풀이;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static boolean solution3(String amountText) {
        boolean answer = true;
        for (char c : amountText.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        char[] chars = amountText.toCharArray();
        if (chars[0] == 0 || chars[chars.length-1] == 'c') {
            return false;
        }
        String[] split = amountText.split(",");
        for (int i = 1; i < split.length; i++) {
            if (split[i].length() != 3) {
                return false;
            }
        }
        if (split[0].length() == 0 || split[split.length - 1].length() == 0) {
            return false;
        }
        return answer;
    }
    public static int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][requests.length];

        answer[0][0] = requests[0];
        int pointL = 1;
        int pointR = 0;
        for (int i = 1; i < requests.length; i++) {
            if (pointL == servers) {
                pointL = 0;
            }
            if (sticky && requests[i - 1] == requests[i]) {
                pointR++;
                answer[pointL][pointR] = requests[i];
                pointL++;
            } else {
                answer[pointL][pointR] = requests[i];
                pointL++;
                if (pointL % servers == 0) {
                    pointR++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution3("123,123"));

        String temp = ",123,1234,";
        String[] split = temp.split(",");

        System.out.println(split.length);
        System.out.println(split[0].length() +" "+split[split.length-1]+" : "+ split[split.length-1].length());

    }
}
