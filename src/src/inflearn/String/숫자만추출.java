package inflearn.String;

import java.util.Scanner;

public class 숫자만추출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String strReplace = str.replaceAll("[A-Za-z]", "");
        Integer answer = Integer.valueOf(strReplace);
        System.out.println(answer);
    }
}
