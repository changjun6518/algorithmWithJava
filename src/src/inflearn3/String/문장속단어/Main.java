package inflearn3.String.문장속단어;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();

        String answer = "";

        for (String s : next.split(" ")) {
            if (answer.length() < s.length()) {
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
