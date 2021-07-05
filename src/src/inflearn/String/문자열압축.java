package inflearn.String;

import java.util.Scanner;


public class 문자열압축 {
    public static void main(String[] args) {
//        KKHSSSSSSSE
//        K2HS7E

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        int count = 1;

        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i - 1);
            if (c == str.charAt(i)) {
                count++;
                if (i == str.length() - 1) {
                    sb.append(String.valueOf(count));
                }
            } else {
                if (count != 1) {
                    sb.append(String.valueOf(count));
                    count = 1;
                }
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb.toString());

    }
}
