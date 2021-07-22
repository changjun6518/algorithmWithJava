package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println(DFS(number));
    }

    public static int DFS(int number) {
        if (number == 1) {
            return 1;
        }  else {
            return number*DFS(number - 1);
        }
    }
}
