package codingTest.Data_Structure.요세푸스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = K - 1;
        while (!list.isEmpty()) {
            while (index >= list.size()) {
                index -= list.size();
            }
            answer.add(list.remove(index));
            index += K - 1;
        }

        String answerList = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("<" + answerList + ">");
    }


}
