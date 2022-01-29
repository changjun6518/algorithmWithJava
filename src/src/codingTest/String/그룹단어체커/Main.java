package codingTest.String.그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        String word;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();
            HashSet<Character> set = new HashSet<>();
            set.add(word.charAt(0));
            char prev = word.charAt(0);
            int count = 0;
            for (int j = 1; j < word.length(); j++) {
                if (prev == word.charAt(j)) {
                    count++;
                } else {
                    set.add(word.charAt(j));
                    prev = word.charAt(j);
                }
            }
            if (set.size() + count == word.length()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
//3
//happy
//new
//year