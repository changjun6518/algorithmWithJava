package programmers.level3.네트워크;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int n = 3;
        visited = new boolean[n];
        // 완탐
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, i);
            }
        }
    }

    static void dfs(int[][] computers, int node) {
        visited[node] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }
}
