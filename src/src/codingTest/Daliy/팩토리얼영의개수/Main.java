package codingTest.Daliy.팩토리얼영의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        int count = 1;
        int assign = getZero(count);
        while (assign < M) {
            count++;
            assign = getZero(count);
        }

        if (assign == M) {
            System.out.println(count * 5);
        } else {
            System.out.println(-1);
        }

        String[] arr = new String[2];

        String temp = "ABC";

    }

    public static int getZero(int count) {
        int num = 1;
        while (count % 5 == 0) {
            num++;
            count /= 5;
        }
        sum += num;
        return sum;
    }
}
