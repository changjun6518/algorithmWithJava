package inflearn.문자열;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {
    public static void main(String[] args) {
        ArrayList<String> answer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        for (String s : arr) {
            String temp = new StringBuilder(s).reverse().toString();
            answer.add(temp);
        }

        for (String s : answer) {
            System.out.println(s);
        }


    }
}
