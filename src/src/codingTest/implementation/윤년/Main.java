package codingTest.implementation.윤년;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("1");
                    return;
                }
                System.out.println("0");
                return;
            }
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}
