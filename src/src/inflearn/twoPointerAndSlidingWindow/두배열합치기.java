package inflearn.twoPointerAndSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class 두배열합치기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        3
//1 3 5
//5
//2 3 6 7 9

        int num1 = sc.nextInt();
        int[] arr1 = new int[num1];
        for (int i = 0; i < num1; i++) {
            arr1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        int[] arr2 = new int[num2];
        for (int i = 0; i < num2; i++) {
            arr2[i] = sc.nextInt();
        }

        int pos1 = 0;
        int pos2 = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (pos1 < num1 && pos2 < num2) {
            if (arr1[pos1] < arr2[pos2]) {
                answer.add(arr1[pos1]);
                pos1++;
            } else {
                answer.add(arr2[pos2]);
                pos2++;
            }
        }
        while (pos1 < num1) {
            answer.add(arr1[pos1]);
            pos1++;
        }
        while (pos2 < num2) {
            answer.add(arr2[pos2++]);
        }

        for (Integer i : answer) {
            System.out.printf(i+" ");
        }
    }
}
