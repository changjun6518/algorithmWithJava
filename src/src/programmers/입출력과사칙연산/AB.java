package programmers.입출력과사칙연산;

import java.util.Scanner;

public class AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        sc.nextLine();
        String sec = sc.nextLine();
        String[] secNum = sec.split("");
        for (int i = secNum.length - 1; i >= 0; i--) {
            int B = Integer.parseInt(secNum[i]);
            System.out.println(A*B);
        }
        int C = Integer.parseInt(sec);
        System.out.println(A*C);
    }
}
