package programmers.twenty_one.풀었던것.라인;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainTwo {
    //  research가 주워짐
    //  일 기준으로 어떤 검색어가 몇번 검색되었는지 정리     ->      hashMap<char,hashMap<int,int>>로 검색어 + 날짜 + 몇번 있는지 관리
    //  어떤 검색어가 연속된 N일동안 k번 이상 검색되고 연속된 n일동안 2nk 이상 검색되면 이슈 검색어가 됨      ->      위 해쉬로 인덱스로 검사하기
    //  이슈 검색어 중에 가장 여러번 이슈 검색어가 된 검색어가 최고의 이슈 검색어      ->      이슈 검색어 카운트는?    hashMap<char, int> count로 관리!?

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] research = {"yxxy", "xxyyy"};
        int n = 2;
        int k = 2;

        System.out.println(solution(research, n, k));

    }

    public static String solution(String[] research, int n, int k) {
        HashMap<Character, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= research.length; i++) {
            String s = research[i - 1];
            for (char c : s.toCharArray()) {
                //  c검색어 i날짜에 count를 +하겠다
                graph.put(c, graph.getOrDefault(c, new HashMap<>()));

                HashMap<Integer, Integer> cSearch = graph.get(c);
                cSearch.put(i, cSearch.getOrDefault(i, 0) + 1);
            }
        }
        int answer = 0;
        char ans = ' ';
        for (Character c : graph.keySet()) {
            int cIssue = issueCheck(c, n, k, graph);
            if (answer < cIssue) {
                answer = cIssue;
                ans = c;
            }
        }
        if (answer == 0) {
            return "None";
        }
        return String.valueOf(ans);

    }

    // 소문자 순서대로해야댐
    public static int issueCheck(char c, int n, int k, HashMap<Character, HashMap<Integer, Integer>> graph) {
        int count = 0;
        int kCount = 0;
        for (int i = 1; i <= graph.size() - n; i++) {
            for (int j = i; j < i + n; j++) {
                if (!graph.get(c).containsKey(j)) {
                    continue;
                }
                if (graph.get(c).get(j) >= k) {
                    kCount++;
                }
            }
            if (kCount == n) {
                count++;
            }
        }

        return count;
    }
}
