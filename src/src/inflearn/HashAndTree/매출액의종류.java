package inflearn.HashAndTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 매출액의종류 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        7 4
//20 12 20 10 23 17 10
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int rt = k - 1;
        for (int i = 0; i < rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        while (rt < n) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            System.out.print(map.size() + " ");

            map.replace(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
            rt++;
        }


    }
}
