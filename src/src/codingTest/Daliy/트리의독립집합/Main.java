package codingTest.Daliy.트리의독립집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int[] value;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static ArrayList<Integer> connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        value = new int[N];
        visited = new boolean[N];
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        String s = "";
//        while ((s = br.readLine()) != null) {
        for (int i = 0; i < 6; i++) {
            s = br.readLine();

            st = new StringTokenizer(s);
            int index = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            lists[index - 1].add(next - 1);
        }
        ArrayList<Integer> answer = null;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                connect = new ArrayList<>();
                checkSum(i);
//                temp(0);
                System.out.println(connect.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));

                int sum = connect.stream()
                        .mapToInt(a -> value[a])
                        .sum();
                if (max < sum) {
                    max = sum;
                    answer = connect;
                }

            }
        }

        System.out.println(max);
        System.out.println(answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    public static void checkSum(int index) {
        if (!visited[index]) {
            visited[index] = true;
            System.out.println("index = " + (index+1));
            connect.add(index);

            for (Integer next : lists[index]) {
                System.out.println("next = " + (next+1));
                checkSum(next);
            }
        }
    }

    public static void temp(int index) {
        if (index > 5) {
            return;
        }
        connect.add(index);
        temp(index + 1);
    }
}
