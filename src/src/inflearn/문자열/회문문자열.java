package inflearn.문자열;

import java.util.Scanner;

public class 회문문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();

        String strReverse = new StringBuilder(str).reverse().toString();
//        boolean b = str.equalsIgnoreCase(strReverse);
        if (str.equals(strReverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
