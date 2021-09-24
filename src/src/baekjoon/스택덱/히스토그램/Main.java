package baekjoon.스택덱.히스토그램;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        long area = getArea(0, N);
        System.out.println(area);

    }

    public static long getArea(int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }

        int mid = (lo + hi) / 2;

        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);

        long max = Math.max(leftArea, rightArea);

        max = Math.max(max, getMidArea(lo, hi, mid));

        return max;

    }

    public static long getMidArea(int lo, int hi, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = arr[mid];
        long maxArea = height;

        while (lo < toLeft && toRight < hi) {
            if (arr[toLeft - 1] < arr[toRight + 1]) {
                height = Math.min(height, arr[toRight + 1]);
                toRight++;
            } else {
                height = Math.min(height, arr[toLeft - 1]);
                toLeft--;
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < hi) {
            toRight++;
            height = Math.min(height, arr[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        while (lo < toLeft) {
            toLeft--;
            height = Math.min(height, arr[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        return maxArea;
    }
}
