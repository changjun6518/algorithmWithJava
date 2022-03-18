package codingTest.Daliy.DNA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> dnaList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String dna = br.readLine();
            dnaList.add(dna);
        }

        for (int i = 0; i < M; i++) {
            Map<Character, Integer> hashMap = new TreeMap<>();
            for (int j = 0; j < N; j++) {
                String dna = dnaList.get(j);
                hashMap.put(dna.charAt(i), hashMap.getOrDefault(dna.charAt(i), 0) + 1);
            }
            int max = 0;
            for (Integer value : hashMap.values()) {
                max = Math.max(value, max);
            }
            count += (N - max);

            for (Character c : hashMap.keySet()) {
                if (hashMap.get(c) == max) {
                    answer.append(c);
                    break;
                }
            }
        }

        System.out.println(answer);
        System.out.println(count);
    }
}
//5 8
//TATGATAC
//TAAGCTAC
//AAAGATCC
//TGAGATAC
//TAAGATGT

// 1. 아이디어 제일 작은 유전자 거리
// 새로운 s를 찾는 것
// 1000개 이하 이므로 완전탐색
// 첫 자리수부터 문자 카운트해서 제일 큰 값 찾고 아닌 것들 갯수 카운트 하기

// 2. 시간복잡도
// 1000 x 50
// O(N * len)

// 3. 자료구조
// 하나의 반복문 마다 Hashmap