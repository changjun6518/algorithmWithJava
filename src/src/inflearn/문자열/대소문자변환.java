package inflearn.문자열;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 대소문자변환 {

    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }

        }
        System.out.printf(result);

    }

}
