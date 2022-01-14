package programmers.level3.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static ArrayList<String> answers;
    public static boolean[] visited;

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        answers = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(0, tickets, "ICN", "ICN");
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        for (String s : answer) {
            System.out.print(s + " ");
        }

    }

    public static void dfs(int level, String[][] tickets,String present, String answer) {
        if (level == tickets.length) {
            answers.add(answer);
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(present)) {
                    visited[i] = true;
                    dfs(level + 1, tickets, tickets[i][1], answer + " " + tickets[i][1]);
                }
            }
        }
    }

}

// [a, b] a->b

