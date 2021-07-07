package inflearn.Array;

import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] ArrA = new int[num];
        int[] ArrB = new int[num];
        for (int i = 0; i < num; i++) {
            ArrA[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            ArrB[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            if (ArrA[i] == ArrB[i]) {
                System.out.println("D");
            } else if (ArrA[i] == 1 && ArrB[i] == 3) {
                System.out.println("A");
            } else if (ArrA[i] == 2 && ArrB[i] == 1) {
                System.out.println("A");
            } else if (ArrA[i] == 3 && ArrB[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }


    }
}
