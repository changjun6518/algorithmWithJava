package inflearn.HashAndTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 모든아나그램찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        bacaAacba
//abc
        String str = sc.next();
        String target = sc.next();

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for (char c : target.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int L = target.length() - 1;

        for (int lt = 0; lt < L; lt++) {
            mapB.put(str.charAt(lt), mapB.getOrDefault(str.charAt(lt), 0) + 1);
        }
        int lt = 0;
        for (int rt = L; rt < str.length(); rt++) {
            mapB.put(str.charAt(rt), mapB.getOrDefault(str.charAt(rt), 0) + 1);
            if (mapA.equals(mapB)) {
                count++;
            }
            mapB.put(str.charAt(lt), mapB.get(str.charAt(lt)) - 1);
            if (mapB.get(str.charAt(lt)) == 0) {
                mapB.remove(str.charAt(lt));
            }
            lt++;
        }

        System.out.println(count);
    }
}
