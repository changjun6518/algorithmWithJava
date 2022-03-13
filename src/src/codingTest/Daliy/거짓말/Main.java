package codingTest.Daliy.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] people;
    static boolean[] party;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        people = new boolean[N + 1];
        party = new boolean[M];
        List<Integer> q = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int truePeople = Integer.parseInt(st.nextToken());

        if (truePeople != 0) {
            for (int i = 0; i < truePeople; i++) {
                int trueMan = Integer.parseInt(st.nextToken());
                people[trueMan] = true;
                q.add(trueMan);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < partyCount; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.put(i, list);
        }


        boolean flag = true;
        while (flag) {
            flag = false;
            for (Integer partyIndex : map.keySet()) {
                int count = 0;
                if (!party[partyIndex]) {
                    List<Integer> list = map.get(partyIndex);
                    for (Integer man : list) {
                        if (q.contains(man)) {
                            party[partyIndex] = true;
                            count++;
                            break;
                        }
                    }
                    if (count != 0) {
                        flag = true;
                        for (Integer man : list) {
                            if (!people[man]) {
                                q.add(man);
                                people[man] = true;
                            }
                        }
                    }
                }
            }

        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (!party[i]) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
