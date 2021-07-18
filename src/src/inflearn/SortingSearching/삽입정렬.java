package inflearn.SortingSearching;

import java.util.Scanner;

public class 삽입정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < total; i++) {
            int temp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = temp;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}
