package inflearn.문자열;

import java.util.Locale;
import java.util.Scanner;

public class 문자찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = sc.nextLine();
        int count = 0;
        String strLower = str.toLowerCase(Locale.ROOT);
        String sLower = s.toLowerCase(Locale.ROOT);
        char c = sLower.charAt(0);

        for (int i = 0; i < strLower.length(); i++) {
            char c1 = strLower.charAt(i);
            if (c == c1) {
                count++;
            }
        }

        System.out.println(count);

    }
}
