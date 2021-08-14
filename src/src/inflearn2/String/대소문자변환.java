package inflearn2.String;

import java.util.Scanner;

public class 대소문자변환 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(Character.toLowerCase(c));
            }
        }

        System.out.println(answer);
    }
}
//StuDY