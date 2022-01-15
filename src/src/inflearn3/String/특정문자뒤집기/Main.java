package inflearn3.String.특정문자뒤집기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int l = 0;
        int r = str.length() - 1;
        char[] chars = str.toCharArray();

        while (l <= r) {
            if (!Character.isAlphabetic(chars[l])) {
                l++;
            }
            else if (!Character.isAlphabetic(chars[r])) {
                r--;
            } else {
                char lChar = chars[l];
                chars[l] = chars[r];
                chars[r] = lChar;
                l++;
                r--;
            }
        }

        System.out.println(chars);
    }
}
