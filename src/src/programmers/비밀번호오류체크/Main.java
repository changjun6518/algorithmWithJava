package programmers.비밀번호오류체크;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] solution = solution(str);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(String inp_str) {
        HashSet<Integer> results = new HashSet<>();
        // 1. 8<= password 길이 <= 15

        if (inp_str.length() < 8 || inp_str.length() > 15) {
            results.add(1);
        }

        // 2. 알파벳 대문자 (A~Z)
        //    알파벳 소문자 (a~z)
        //    0~9
        //    ~!@#$%^&*
        int AFlag = 0;
        int aFlag = 0;
        int iFlag = 0;
        int sFlag = 0;
        ArrayList<Character> checkSymbol = new ArrayList<>();
        checkSymbol.add('~');
        checkSymbol.add('!');
        checkSymbol.add('@');
        checkSymbol.add('#');
        checkSymbol.add('$');
        checkSymbol.add('%');
        checkSymbol.add('^');
        checkSymbol.add('&');
        checkSymbol.add('*');

        HashMap<Character, Integer> sameSymbol = new HashMap<>();
        int dupCount = 1;
        for (int i = 0; i < inp_str.length(); i++) {
            char c = inp_str.charAt(i);
            if (Character.isUpperCase(c)) {
                AFlag = 1;
            } else if (Character.isLowerCase(c)) {
                aFlag = 1;
            } else if (Character.isDigit(c)) {
                iFlag = 1;
            } else {
                if (checkSymbol.contains(c)) {
                    sFlag = 1;
                    continue;
                }
                results.add(2);
            }

        // 4. 같은 문자 4개이상 연속 X
            if (i != 0) {
                char post = inp_str.charAt(i - 1);
                if (post == c) {
                    dupCount++;
                    if (dupCount >= 4) {
                        results.add(4);
                    }
                } else dupCount = 1;
            }

        // 5. 같은 문자 5개이상 포함 X
            sameSymbol.put(c, sameSymbol.getOrDefault(c, 0) + 1);
            if (sameSymbol.get(c) >= 5) {
                results.add(5);
            }
        }

        // 3. 2번 경우중 3개 이상 포함
        int count = 0;
        count += AFlag;
        count += aFlag;
        count += iFlag;
        count += sFlag;
        if (count < 3) {
            results.add(3);
        }

        if (results.isEmpty()) {
            results.add(0);
        }

        int[] resultNew = new int[results.size()];

        int i = 0;
        for (Integer num : results) {
            resultNew[i++] = num;
        }

        Arrays.sort(resultNew);

        return resultNew;
        // 6. 위배되는 규칙들을 배열에 담아 오름차순 정렬 후 return
        // 7. 위배규칙 없다면 0을 담아 return
        // 8. 1<= in[_str <= 1000000



    }
}
