package codingTest.Greedy.폴리오미노;

import java.util.Scanner;

public class Main {
    static String A = "AAAA";
    static String B = "BB";
    static int count = 0;
    public static void main(String[] args) {
//        XX.XX
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                if (addPoly(sb)) {
                    System.out.println("-1");
                    return;
                }
                sb.append(".");
            }
        }

        if (addPoly(sb)) {
            System.out.println("-1");
            return;
        }

        System.out.println(sb.toString());

    }

    static private boolean addPoly(StringBuilder sb) {

        sb.append(A.repeat(count / 4));
        count -= 4 * (count / 4);

        sb.append(B.repeat(count / 2));
        count -= 2 * (count / 2);

        return count > 0;
    }
}
