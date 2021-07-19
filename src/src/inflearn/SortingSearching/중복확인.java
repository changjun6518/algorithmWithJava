package inflearn.SortingSearching;

import java.util.Scanner;

public class 중복확인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        8
//20 25 52 30 39 33 43 33

        int studentNum = sc.nextInt();
        int[] arr = new int[studentNum];

        for (int i = 0; i < studentNum; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < studentNum; i++) {
            if (checkDuplicate(arr, arr[i])) {
            } else {
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");

        return;
    }

    public static boolean checkDuplicate(int[] arr, int num) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == num) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else return false;
    }
}
