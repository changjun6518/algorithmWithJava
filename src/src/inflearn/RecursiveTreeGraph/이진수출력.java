package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 이진수출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        DFS(number);
    }

    public static void DFS(int number) {
        if (number == 0) {
            return;
        } else {
            DFS(number / 2);
            System.out.print(number%2);
        }
    }
}
