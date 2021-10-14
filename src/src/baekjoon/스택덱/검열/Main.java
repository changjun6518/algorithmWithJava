package baekjoon.스택덱.검열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String key = br.readLine();
        int keyLen = key.length();
        StringBuilder text = new StringBuilder(br.readLine());

        LinkedList<Character> Q = new LinkedList<>();

        int start = 0;
        int end = text.length() - 1;

        boolean isLeft = true;

        while (start <= end) {
            if (isLeft) {
                Q.addFirst(text.charAt(start++));
                if (Q.size() >= keyLen && Q.peekFirst() == key.charAt(keyLen - 1)) {
                    boolean check = true;
                    int keyL = keyLen;
                    for (int i = 0; i < Q.size(); i++) {
                        if (Q.get(i) != key.charAt(keyL--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isLeft = false;
                        for (int i = 0; i < keyLen; i++) {
                            Q.pollFirst();
                        }
                    }
                }
            }
        }


    }


}
