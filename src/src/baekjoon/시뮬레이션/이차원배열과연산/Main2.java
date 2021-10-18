package baekjoon.시뮬레이션.이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] arr = new int[101][101];
    static int r;
    static int c;
    static int k;
    static int rLen = 3;
    static int cLen = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(operation());

    }

    public static int operation() {
        for (int i = 0; i <= 100; i++) {
            if (arr[r][c] == k) {
                return i;
            }
            if (rLen >= cLen) {
                R();
            } else {
                C();
            }
        }
        return -1;
    }

    public static void R() {
        for (int i = 1; i <= rLen; i++) {
            PriorityQueue<Pair> pQ = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= cLen; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
//                map.compute(arr[i][j], (num, count) -> count == null ? 1 : count + 1);

                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
            for (Integer key : map.keySet()) {
                pQ.add(new Pair(key, map.get(key)));
            }
            int x = 1;
            while (!pQ.isEmpty()) {
                Pair now = pQ.poll();
                arr[i][x++] = now.num;
                arr[i][x++] = now.count;
            }
            cLen = Math.max(cLen, x);

            while (x <= 100) {
                arr[i][x++] = 0;
            }
        }
    }

    public static void C() {
        for (int i = 1; i <= cLen; i++) {
            PriorityQueue<Pair> pQ = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= rLen; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
//                map.compute(arr[j][i], (num, count) -> count == null ? 1 : count + 1);

                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }
            for (Integer key : map.keySet()) {
                pQ.add(new Pair(key, map.get(key)));
            }
            int x = 1;
            while (!pQ.isEmpty()) {
                Pair now = pQ.poll();
                arr[x++][i] = now.num;
                arr[x++][i] = now.count;
            }
            rLen = Math.max(rLen, x);

            while (x <= 100) {
                arr[x++][i] = 0;
            }
        }
    }


    public static class Pair implements Comparable<Pair>{
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (count == o.count) {
                return num - o.num;
            }
            return count - o.count;
        }
    }
}
