package inflearn.SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        8 32
//23 87 65 12 57 32 99 81

        int total = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = binarySearch(arr, target);

        System.out.println(answer);

    }

    public static int binarySearch(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length - 1;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            } else if (arr[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return -1;
    }

}
