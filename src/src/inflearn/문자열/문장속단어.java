package inflearn.문자열;

import java.util.Scanner;

public class 문장속단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        String result = "";

        for (String s1 : s) {
            if (result.length() < s1.length()) {
                result = s1;
            }
        }

        System.out.println(result);

    }
}