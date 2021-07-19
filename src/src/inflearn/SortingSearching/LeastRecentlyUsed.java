package inflearn.SortingSearching;

import java.util.LinkedList;
import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5 9
//1 2 3 2 6 2 3 5 7
        int arrSize = sc.nextInt();
        int working = sc.nextInt();
        int[] arr = new int[arrSize];

        for (int i = 0; i < working; i++) {
            int work = sc.nextInt();
            int checkNum = checkContain(arr, work);
            if (checkNum == -1) {
                // 없으면
                pushback(arr, arr.length, work);
            } else {
                // 있으면
                swap(arr, checkNum);
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static int checkContain(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void pushback(int[] arr,int length ,int newOne) {
        for (int i = length-1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newOne;
    }

    public static void swap(int[] arr, int index) {
        int temp = arr[index];
        pushback(arr, index+1, temp);
    }
}
