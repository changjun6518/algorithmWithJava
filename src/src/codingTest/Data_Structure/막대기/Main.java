package codingTest.Data_Structure.막대기;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);

        while (sum(pq) > X) {
            Integer shortBar = pq.poll();
            int halfBar = shortBar >> 1;
            pq.add(halfBar);
            if (sum(pq) < X) {
                pq.add(halfBar);
            }
        }
        System.out.println(pq.size());

    }

    public static int sum(PriorityQueue<Integer> pq) {
        int sum = 0;
        for (Integer integer : pq) {
            sum += integer;
        }
        return sum;
    }
}
