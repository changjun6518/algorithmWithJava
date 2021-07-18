package inflearn.SortingSearching;

import java.util.Scanner;

public class 선택정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        6
//13 5 11 7 23 15

        int total = sc.nextInt();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < total; i++) {
            int index = i;
            for (int j = i + 1; j < total; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }


        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}
