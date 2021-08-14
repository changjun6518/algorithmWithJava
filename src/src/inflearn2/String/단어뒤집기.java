package inflearn2.String;

import java.util.Scanner;

public class 단어뒤집기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            String str = new StringBuilder(next).reverse().toString();
            System.out.println(str);
        }
    }
}
//3
//good
//Time
//Big
