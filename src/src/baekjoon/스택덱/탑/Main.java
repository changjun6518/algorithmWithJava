package baekjoon.스택덱.탑;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static class Top {
        int idx;
        int height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
//        5
//6 9 5 7 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Scanner scanner = new Scanner(System.in);
//0 0 2 2 4
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            Top nowTop = new Top(i, height);

            if (stack.isEmpty()) {
                answer.append("0 ");
                stack.add(nowTop);
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        answer.append("0 ");
                        stack.push(nowTop);
                        break;
                    }

                    Top preTop = stack.peek();

                    if (preTop.height > nowTop.height) {
                        answer.append(preTop.idx).append(" ");
                        stack.push(nowTop);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            Top preTop = stack.peek();

            if (preTop.height > nowTop.height) {
                System.out.print(preTop.idx + " ");
                stack.add(nowTop);
            } else {
                while (!stack.isEmpty() && preTop.height < nowTop.height) {
                    stack.pop();
                }

            }

        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
