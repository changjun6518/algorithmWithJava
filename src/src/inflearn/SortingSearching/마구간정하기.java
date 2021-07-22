package inflearn.SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5 3
//1 2 8 4 9

        int total = sc.nextInt();
        int horses = sc.nextInt();

        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int lt = arr[0];
        int rt = arr[arr.length - 1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (checkAbleHorse(arr, mid) >= horses) {
                answer = mid;
                lt = mid + 1;

            } else rt = mid - 1;
        }

        System.out.println(answer);
    }

    public static int checkAbleHorse(int[] arr, int interval) {
        int cnt = 1;
        int lt = 0;
        int rt = 1;

        while (rt < arr.length) {
            if ((arr[rt] - arr[lt]) < interval) {
                rt++;
            } else {
                cnt++;
                lt = rt;
            }
        }
        return cnt;
    }
}
