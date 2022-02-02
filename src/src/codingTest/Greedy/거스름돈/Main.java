package codingTest.Greedy.거스름돈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int change = sc.nextInt();
        int coin = 0;

        if (change % 5 == 0) {
            System.out.println(change / 5);
        } else {
            while (true) {
                if (change < 0) {
                    System.out.println(-1);
                    break;
                } else if (change % 5 == 0) {
                    coin += change / 5;
                    System.out.println(coin);
                    break;
                } else {
                    change -= 2;
                    coin++;
                }
            }
        }
    }
}
