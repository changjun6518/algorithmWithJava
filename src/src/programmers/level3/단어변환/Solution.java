package programmers.level3.단어변환;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        DFS dfs = new DFS(words, "hit", "cog");
        int answer = dfs.solution();
        System.out.println("answer = " + answer);
    }

    private static class DFS {
        private int answer = Integer.MAX_VALUE;
        private boolean[] visited;
        private String[] words;
        private String begin;
        private String target;

        public DFS(String[] words, String begin, String target) {
            this.words = words;
            this.begin = begin;
            this.target = target;
        }

        public int solution() {
            visited = new boolean[words.length];
            if (checkPossible()) {
                execute(begin, 0);
                return answer;
            }
            return 0;
        }

        private void execute(String now, int level) {
            if (now.equals(target)) {
                answer = Math.min(answer, level);
            } else {
                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;

                    if (!checkOneDifferent(words[i], now)) continue;

                    visited[i] = true;
                    execute(words[i], level + 1);
                    visited[i] = false;
                }
            }
        }


        private boolean checkOneDifferent(String word, String now) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != now.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }

        private boolean checkPossible() {
            for (String word : words) {
                if (word.equals(target)) {
                    return true;
                }
            }
            return false;
        }

    }
}
