package inflearn.SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//    9
//120 125 152 130 135 135 143 127 160

        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        String answer = "";
        int[] temp = arr.clone();
        Arrays.sort(arr);

        for (int i = 0; i < num; i++) {
            if (arr[i] != temp[i]) {
                answer += String.valueOf(i + 1) + " ";
            }
        }

        System.out.println(answer);
    }
}
