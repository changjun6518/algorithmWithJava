package inflearn.String;

import java.util.Scanner;

public class 유효한팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();

        String strReplace = str.replaceAll("[^A-Z]", "");

        String strReverse = new StringBuilder(strReplace).reverse().toString();

        if (strReplace.equals(strReverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
