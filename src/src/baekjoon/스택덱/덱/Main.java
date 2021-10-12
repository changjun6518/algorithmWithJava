package baekjoon.스택덱.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.startsWith("push_back")) {
                String[] s = command.split(" ");
                Q.addLast(Integer.parseInt(s[1]));
            } else if (command.startsWith("push_front")) {
                String[] s = command.split(" ");
                Q.addFirst(Integer.parseInt(s[1]));
            } else if (command.startsWith("pop_front")) {
                if (Q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                Integer p = Q.pollFirst();
                System.out.println(p);
            } else if (command.startsWith("pop_back")) {
                if (Q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(Q.pollLast());
            } else if (command.startsWith("size")) {
                System.out.println(Q.size());
            } else if (command.startsWith("empty")) {
                if (Q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.startsWith("front")) {
                if (Q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(Q.peekFirst());
            } else if (command.startsWith("back")) {
                if (Q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(Q.peekLast());
            }

        }

    }
}
