package inflearn3.String.단어뒤집기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            String str = scanner.next();
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        }
    }
}
