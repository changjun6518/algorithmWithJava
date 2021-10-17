package baekjoon.시뮬레이션.이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int[][] arr = new int[100][100];
    static int r;
    static int c;
    static int k;
    static int rSize;
    static int cSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        rSize = 3;
        cSize = 3;
        for (int i = 0; i < 3; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }
        // 행 열의 크기를 구하기
        // R 연산 
        // C 연산
        // 연산  =  각각의 수가 몇번 나왔는지 파악하고 횟수가 커지는 순으로 나열, 횟수가 동일하면 작은 것 부터 나열
    }

    public static void calR() {
        for (int i = 0; i < rSize; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < cSize; j++) {
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
            for (Integer key : map.keySet()) {

            }
        }
    }


}
// 0.0 0.1 0.2
// 1.0 1.1 1.2
// 2.0 2.1 2.2