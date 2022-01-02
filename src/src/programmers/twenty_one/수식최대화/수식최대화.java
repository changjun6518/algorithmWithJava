package programmers.twenty_one.수식최대화;

import java.util.ArrayList;

public class 수식최대화 {
    private static ArrayList<Long> num = new ArrayList<>();
    private static ArrayList<Character> operator = new ArrayList<>();
    private static ArrayList<Character> result = new ArrayList<>();
    private static ArrayList<Character> base = new ArrayList<>();
    public static void main(String[] args) {
        base.add('-');
        base.add('*');
        base.add('+');
        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        division(expression);
        boolean[] visited = new boolean[operator.size()];
//        per(base, result, visited, 0, 3, 3);
        long answer = 0;
        return answer;
    }

    // 일단 연산문자로 나누고
    public static void division(String expression) {
        String[] numString = expression.split("\\+|\\*|-");
        for (String n : numString) {
            System.out.printf("%s", n);
            Long aLong = Long.valueOf(n);
            num.add(aLong);
        }
        String[] operationString = expression.split("[0-9]+");
        for (String o : operationString) {
            System.out.printf("%s", o);
            if (o.equals("")) {
                continue;
            }
            char c = o.charAt(0);
            operator.add(c);
        }
        print();
    }


    public static void print() {
        for (int i = 0; i < num.size(); i++) {
            System.out.printf("%d : %s\n", i, num.get(i));
        }
        for (int i = 0; i < operator.size(); i++) {
            System.out.printf("%d : %s\n", i, operator.get(i));
        }
    }

    // 모든 경우의 수로 계산하고
    // 순열로 합니다
//    public static void per(ArrayList<Character> base,
//                           ArrayList<Character> result,
//                           boolean[] visited,
//                           int depth,
//                           int n,
//                           int r) {
//        if (depth == r) {
//            // 계산 해
//            for (Character c : result) {
//                System.out.printf("%c", c);
//            }
//            System.out.println();
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (visited[i] != true) {
//                visited[i] = true;
//                result.add(i, base.get(i));
//                result.
//                per(base, result, visited, depth + 1, n, r);
//                visited[i] = false;
//            }
//        }
//
//    }

    // 계산 함수
//    public static String[] cal(String[] temp, String op) {
//        for (int i = 0; i < temp.length; i++) {
//            if (operator[i].equals(op)) {
//                int result;
//                if (op.equals("+")) {
//                    result = Integer.parseInt(temp[i - 1]) + Integer.parseInt(temp[i]);
//                } else if (op.equals("-")) {
//                    result = Integer.parseInt(temp[i - 1]) - Integer.parseInt(temp[i]);
//                } else {
//                    result = Integer.parseInt(temp[i - 1]) * Integer.parseInt(temp[i]);
//                }
//                temp[i] = String.valueOf(result);
//            }
//        }
//
//        return temp;
//    }


    // 값을 비교해서 제일 높은 수 리턴

}
