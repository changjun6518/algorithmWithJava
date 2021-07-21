package inflearn.SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오_결정알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        9 3
//1 2 3 4 5 6 7 8 9

        int total = sc.nextInt();
        int targetBoundary = sc.nextInt();

        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(arr, mid) <= targetBoundary) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(answer);
    }

    public static int check(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            } else {
                sum += i;
            }
        }
        return cnt;
    }
}
