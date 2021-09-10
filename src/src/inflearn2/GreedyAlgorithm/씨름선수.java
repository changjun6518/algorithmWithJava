package inflearn2.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 씨름선수 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//5
//172 67
//183 65
//180 70
//170 72
//181 60
        int N = scanner.nextInt();

        ArrayList<People> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            people.add(new People(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(people);
        greedy(people);

        System.out.println(count);

    }

    public static void greedy(ArrayList<People> people) {
        int max = 0;
        for (People person : people) {
            if (max < person.height) {
                max = person.height;
                count++;
            }
        }
    }

    private static class People implements Comparable<People>{
        int weight;
        int height;

        public People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(People o) {
            return o.weight - weight;
        }
    }
}
