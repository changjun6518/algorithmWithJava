package programmers.twenty_one.풀었던것;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 미국식숫자오름차순 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");

        ArrayList<String> strAnswer = new ArrayList<>();

        for (String s : split) {

            String s1 = intToString(s);
            strAnswer.add(s1);

        }

        Collections.sort(strAnswer);
        int[] answer = new int[strAnswer.size()];

        for (int i = 0; i < strAnswer.size(); i++) {
            answer[i] = Integer.parseInt(strAnswer.get(i));
        }

        for (int i : answer) {
            System.out.println(i);
        }

    }

    public static String intToString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '1':
                    sb.append("one");
                    break;
                case '2':
                    sb.append("two");
                    break;
                case '3':
                    sb.append("three");
                    break;
                case '4':
                    sb.append("four");
                    break;
                case '5':
                    sb.append("five");
                    break;
                case '6':
                    sb.append("six");
                    break;
                case '7':
                    sb.append("seven");
                    break;
                case '8':
                    sb.append("eight");
                    break;
                case '9':
                    sb.append("nine");
                    break;
                case '0':
                    sb.append("zero");
                    break;
            }
        }

        return sb.toString();
    }
    public static int stirngToInt(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '1':
                    sb.append("one");
                    break;
                case '2':
                    sb.append("two");
                    break;
                case '3':
                    sb.append("three");
                    break;
                case '4':
                    sb.append("four");
                    break;
                case '5':
                    sb.append("five");
                    break;
                case '6':
                    sb.append("six");
                    break;
                case '7':
                    sb.append("seven");
                    break;
                case '8':
                    sb.append("eight");
                    break;
                case '9':
                    sb.append("nine");
                    break;
                case '0':
                    sb.append("zero");
                    break;
            }
        }
//        return sb.toString();
        return 1;
    }
}
//