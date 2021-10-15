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

        LinkedList<Character> leftQ = new LinkedList<>();
        LinkedList<Character> rightQ = new LinkedList<>();

        int start = 0;
        int end = text.length() - 1;

        boolean isLeft = true;

        while (start <= end) {
            if (isLeft) {
                leftQ.addFirst(text.charAt(start++));
                if (leftQ.size() >= keyLen && leftQ.peekFirst() == key.charAt(keyLen - 1)) {
                    boolean check = true;
                    int keyL = keyLen-1;
                    for (int i = 0; i < keyLen; i++) {
                        if (leftQ.get(i) != key.charAt(keyL--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isLeft = false;
                        for (int i = 0; i < keyLen; i++) {
                            leftQ.pollFirst();
                        }
                    }
                }
            } else {
                rightQ.addLast(text.charAt(end--));
                if (rightQ.size() >= keyLen && rightQ.peekLast() == key.charAt(0)) {
                    boolean check = true;
                    int keyL = 0;
                    for (int i = rightQ.size() - 1; i > rightQ.size() - 1 - keyLen; i--) {
                        if (rightQ.get(i) != key.charAt(keyL++)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isLeft = true;
                        for (int i = 0; i < keyLen; i++) {
                            rightQ.pollLast();
                        }
                    }
                }
            }
            // 와리가리 끝나고 한쪽으로 몰아서 넣기
        }


        while (!leftQ.isEmpty()) {
            sb.append(leftQ.pollLast());
        }
        while (!rightQ.isEmpty()) {
            sb.append(rightQ.pollLast());
        }

        while (sb.toString().contains(key)) {
            int point = sb.indexOf(key);
            sb.delete(point, point + keyLen);
        }

        System.out.println(sb.toString());


    }


}
