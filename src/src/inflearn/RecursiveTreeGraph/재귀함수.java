package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 재귀함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        recursive(total);
    }

    public static void recursive(int num) {
        if (num == 0) {
            return;
        } else {
            recursive(num - 1);
            System.out.print(num+ " ");
        }


    }
}
