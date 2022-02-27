package codingTest.Daliy.줄세우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer.add(current);

            for (int i = 0; i < list[current].size(); i++) {
                int nextIndex = list[current].get(i);
                indegree[nextIndex]--;
                if (indegree[nextIndex] == 0) {
                    queue.add(nextIndex);
                }
            }
        }

        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
