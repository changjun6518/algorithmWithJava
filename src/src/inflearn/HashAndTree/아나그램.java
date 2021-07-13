package inflearn.HashAndTree;

import java.util.HashMap;
import java.util.Scanner;

public class 아나그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        AbaAeCe
//        baeeACA

        String A = sc.next();
        String B = sc.next();

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char c : A.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        for (char c : B.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        for (char c : A.toCharArray()) {
            if (mapA.get(c) == mapB.get(c)) {
                continue;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
