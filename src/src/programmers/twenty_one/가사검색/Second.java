package programmers.twenty_one.가사검색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //  음   words 길이 2~ 100000
        //  각 가사 단어의 길이 1~10000
        //  전체 가사 단어 길이의 합 2 ~ 1000000
        //  가사에 동일 단어 여러번이면 중복 제거 후 words에 하나로만 제공 -> 중복제거

        //  각 단어 오직 소문자로만 구성

        //  queries 길이 2~100000
        //  검색 키워드 길이 1~10000
        //  전체 합길이  2~1000000
        //  검색 키워드는 중복될 수 있음
        //  오직 소문자와 ? 로 구성
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] solution = solution(words, queries);

        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(String[] words, String[] queries) {
        HashSet<String> newWords = new HashSet<>(Arrays.asList(words));
        int[] result = new int[queries.length];
        // 하나의 쿼리 마다 words를 돈다
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int count = 0;
            for (String word : newWords) {
                //  하나의 쿼리와 word하나를 비교해서 해당하는지 체크   ->  check 함수 만들기
                if (query.length() != word.length()) {
                    continue;
                }
                int first = symbolCheck(query);
                if (first != 0) {
                    if (check(query, word, first)) {
                        count++;
                        continue;
                    }
                }
                int second = symbolCheckReverse(query);
                if (second != query.length() - 1) {
                    if (checkReverse(query, word, second)) {
                        count++;
                        continue;
                    }
                }

                if (check(query, word, 0)) {
                    //  해당하면 count++ 진행
                    count++;
                }
            }
            //  result에 넣기
            result[i] = count;
        }


        return result;
    }

    public static int symbolCheck(String query) {

        int i = 0;
        while (query.charAt(i) == '?') {
            i++;
        }
        return i;
    }
    public static int symbolCheckReverse(String query) {

        int i = query.length() - 1;
        while (query.charAt(i) == '?') {
            i--;
        }
        return i;
    }

    public static boolean check(String query, String word, int index) {
        for (int i = index; i < query.length(); i++) {
            char q = query.charAt(i);
            char w = word.charAt(i);
            if (q != w) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkReverse(String query, String word, int index) {
        for (int i = index; i >=0; i--) {
            char q = query.charAt(i);
            char w = word.charAt(i);
            if (q != w) {
                return false;
            }
        }
        return true;
    }
}
