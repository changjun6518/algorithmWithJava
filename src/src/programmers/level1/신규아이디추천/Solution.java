package programmers.level1.신규아이디추천;

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {

        String id = "...!@BaT#*..y.abcdefghijklm";
        id = id.toLowerCase(Locale.ROOT);
        id = id.replaceAll("[^-_.a-z0-9]", "");
        id = id.replaceAll("[.]{2,}", ".");
        id = id.replaceAll("^[.]|[.]$", "");
        if (id.isEmpty()) {
            id = "a";
        }
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", "");
        }
        while (id.length() <= 2) {
            id = id + id.charAt(id.length() - 1);
        }

        System.out.println(id);

    }
}
