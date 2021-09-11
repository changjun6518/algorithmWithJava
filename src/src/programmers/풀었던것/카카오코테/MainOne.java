package programmers.풀었던것.카카오코테;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        int k2 = 3;


        System.out.println(Arrays.toString(solution(id_list, report, k)));

    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, FromTo> idList = new HashMap<>();

        for (String id : id_list) {
            idList.put(id, new FromTo(0, 0));
        }

        HashSet<String> duplication = new HashSet<>();
        for (String re : report) {
            String[] s = re.split(" ");
            String from = s[0];
            String to = s[1];
            if (duplication.contains(re)) {
                continue;
            }
            duplication.add(re);

            FromTo fromTo = idList.get(to);
            idList.put(to, new FromTo(fromTo.fromCount + 1, fromTo.toCount));
        }
        ArrayList<String> results = new ArrayList<>();
        for (String id : idList.keySet()) {
            FromTo fromTo = idList.get(id);
            if (fromTo.fromCount >= k) {
                results.add(id);
            }
        }
        HashSet<String> duplication2 = new HashSet<>();
        for (String re : report) {
            String[] s = re.split(" ");
            String from = s[0];
            String to = s[1];
            if (duplication2.contains(re)) {
                continue;
            }
            duplication2.add(re);
            for (String stop : results) {
                if (stop.equals(to)) {
                    FromTo fromTo = idList.get(from);
                    idList.put(from, new FromTo(fromTo.fromCount, fromTo.toCount + 1));
                }
            }
        }




        int i = 0;
        int[] answer = new int[idList.size()];
        for (String s : id_list) {
            System.out.println(s);
            answer[i] = idList.get(s).toCount;
            i++;
        }

        return answer;
    }
    private static class FromTo {

        int fromCount;
        int toCount;


        public FromTo(int fromCount, int toCount) {
            this.fromCount = fromCount;
            this.toCount = toCount;
        }
    }
    //  각 유저는 한번에 한명의 유저를 신고
    //  한 유저가 여러번 신고할 수 있지만 1회로 처리
    //  K번 이상 신고된 유저는 정지되며 신고한 유저들에게 정지사실을 메일로 보냄
    //  정지 되어도 신고할 수 있음

    // 유저 ID가 담긴 문자열
    //  각 이용자가 신고한 유저 ID 문자열
    //  정지 기준이 되는 k
    //  각 유저별로 처리 결과를 메일로 받는 횟수를 배열에 담아 return

}



//HashSet<String> dup = new HashSet<>();
//
//        for (String userId : id_list) {
//            hashMap.put(userId, 0);
//        }
//
//        //  1. 신고 당한 횟수 체크
//        for (String rep : report) {
//            if (!dup.contains(rep)) {
//                dup.add(rep);
//                String[] s = rep.split(" ");
//                hashMap.put(s[1], hashMap.get(s[1]) + 1);
//            }
//        }
//
//        //  2. 신고당한 횟수 k보다 많으면 정지된 아이디!
//        ArrayList<String> stopUser = new ArrayList<>();
//        for (String s : hashMap.keySet()) {
//            if (hashMap.get(s) >= k) {
//                stopUser.add(s);
//            }
//        }
//
//        //  3. 정지된 아이디를 신고한 사람 체크
//        HashMap<String, Integer> results = new HashMap<>();
//        for (String userId : id_list) {
//            results.put(userId, 0);
//        }
//        for (String stop : stopUser) {
//            for (String rep : report) {
//                if (!dup.contains(rep)) {
//                    String[] s = rep.split(" ");
//                    if (stop.equals(s[0])) {
//                        results.put(s[0], results.get(s[0]) + 1);
//                    }
//                }
//            }
//        }
//        int[] answer = new int[results.size()];
//        int i = 0;
//        for (String s : results.keySet()) {
//            answer[i] = results.get(s);
//            i++;
//        }
//        return answer;