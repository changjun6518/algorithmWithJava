package inflearn.문자열;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char tar = sc.next().charAt(0);

        int[] answer = new int[str.length()];
        int p =1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tar) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == tar) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(p, answer[i]);
            }
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
