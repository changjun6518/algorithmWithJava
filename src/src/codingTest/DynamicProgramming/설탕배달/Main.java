package codingTest.DynamicProgramming.설탕배달;

import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;
        while (true) {
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            }
            N -= 3;
            answer++;
            if (N < 0) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
}
