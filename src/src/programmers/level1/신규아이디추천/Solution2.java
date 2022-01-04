package programmers.level1.신규아이디추천;

public class Solution2 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 3단계
        new_id = new_id.replaceAll("\\.\\.+", ".");
        // 4단계
        new_id = new_id.replaceAll("(^\\.|\\.$)", "");
        // 5단계
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        // 7단계
        while (new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        System.out.println(new_id);
    }
}
