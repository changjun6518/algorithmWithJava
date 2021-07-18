package inflearn.SortingSearching;

import java.util.Scanner;

public class 버블정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        6
//13 5 11 7 23 15
        int total = sc.nextInt();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        while (total != 0) {
            for (int i = 0; i < total - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            total = total - 1;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}
