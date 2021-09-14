package baekjoon.재귀.Z;

import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);
        find(size, r, c);

        System.out.println(2 * (4 * 4 / 4));
        System.out.println(2 * 4 * 4 / 4);

        System.out.println(count);
    }

    public static void find(int size, int r, int c) {
        if (size == 1) {
            return;
        } else {
            if (r < size / 2 && c < size / 2) {
                find(size / 2, r, c);
            }
            else if (r < size/ 2 && c >= size/ 2) {
                count += size * size / 4;
                System.out.println("count0 = " + count);
                find(size / 2, r, c - size / 2);
            }
            else if (r >= size/ 2 && c < size/ 2) {
                count += 2 * (size * size / 4);
                System.out.println("count1 = " + count);
                find(size / 2, r - size / 2, c);
            }
            else {
                count += 3 * size * size / 4;
                System.out.println("count2 = " + count);
                find(size / 2, r - size / 2, c - size / 2);
            }
        }
    }


}



