package codingTest.Greedy.ATM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        5
//3 1 4 3 2
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
            arr2[i] = temp;
        }
        long start;
        start = System.nanoTime();
        Collections.sort(arr);
        System.out.println("Collection = " + (System.nanoTime() - start));


        start = System.currentTimeMillis();
        Arrays.sort(arr2);
        System.out.println("Arrays = " + (System.nanoTime() - start));

//          1 2 3 3 4 5
        //  1 1+2 1+2+3
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            prev += arr.get(i);
            answer += prev;
        }

        System.out.println(answer);
    }
}
