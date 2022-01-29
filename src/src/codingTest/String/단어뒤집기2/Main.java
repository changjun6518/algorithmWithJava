package codingTest.String.단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean flag = false;

        for (char c : S.toCharArray()) {

            if (flag) {
                answer.append(c);
                if (c == '>') {
                    flag = false;
                }
            } else {
                if (c == '<') {
                    if (word.length() != 0) {
                        answer.append(word.reverse());
                        word.setLength(0);
                    }
                    flag = true;
                    answer.append(c);
                } else if (c == ' ') {
                    answer.append(word.reverse());
                    word.setLength(0);
                    answer.append(c);
                } else {
                    word.append(c);
                }
            }
        }
        answer.append(word.reverse());

        System.out.println(answer.toString());
    }
}