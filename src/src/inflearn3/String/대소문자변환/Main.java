package inflearn3.String.대소문자변환;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb.toString());
    }
}
