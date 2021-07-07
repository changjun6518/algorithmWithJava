package inflearn.Array;

import java.util.Scanner;

public class 큰수출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");


        String answer = "";
        answer += str[0];
        for (int i = 0; i < str.length - 1; i++) {
            if (Integer.parseInt(str[i + 1]) > Integer.parseInt(str[i])) {
                answer += " " + str[i + 1];
            }
        }

        System.out.println(answer);

    }
}
