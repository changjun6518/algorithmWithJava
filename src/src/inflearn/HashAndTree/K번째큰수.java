package inflearn.HashAndTree;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class K번째큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        10 3
//13 15 34 23 45 65 33 11 26 42

        int n = sc.nextInt();
        int k = sc.nextInt();

        // Collections.reverseOrder()
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tree.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (Integer num : tree) {
            cnt++;
            if (cnt == k) {
                System.out.println(num);
                return;
            }
        }
        System.out.println("-1");
    }
}
