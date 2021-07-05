package inflearn.String;

import java.util.Scanner;

public class 특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] c = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(c[lt])) {
                lt += 1;
            } else {
                if (!Character.isAlphabetic(c[rt])) {
                    rt -= 1;
                } else {
                    char temp = c[lt];
                    c[lt] = c[rt];
                    c[rt] = temp;
                    lt += 1;
                    rt -= 1;
                }
            }
        }

        System.out.println(c);
    }
}
