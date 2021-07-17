package inflearn.StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 공주구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNum = sc.nextInt();

        int outNum = sc.nextInt();


        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < totalNum; i++) {
            queue.add(i + 1);
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < outNum-1; i++) {
                queue.offer(queue.poll());
            }
            answer = queue.pop();
        }
        System.out.println(answer);

    }
}
