package inflearn.Dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 가장높은탑쌓기 {
    private static class block implements Comparable<block> {

        public int side;
        public int height;
        public int weight;

        public block(int side, int height, int weight) {
            this.side = side;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(block o) {
            return o.side - this.side;
        }
    }
    static int[] dy;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n];
        ArrayList<block> blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blocks.add(new block(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }


        int solution = solution(blocks);
        System.out.println(solution);

    }

    public static int solution(ArrayList<block> blocks) {
        Collections.sort(blocks);
        int answer = 0;

        dy[0] = blocks.get(0).height;
        answer = dy[0];
        for (int i = 1; i < blocks.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks.get(i).weight < blocks.get(j).weight && max < dy[j]) {
                    max = dy[j];
                }
                dy[i] = max + blocks.get(i).height;
                answer = Math.max(dy[i], answer);
            }
        }
        return answer;
    }
}
//5
//25 3 4
//4 4 6
//9 2 3
//16 2 5
//1 5 2