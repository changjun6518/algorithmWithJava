### dynamic programming

[계단오르기](계단오르기.java)

큰 것을 작은 것으로 쪼개서 풀어나간다 (피보나치)

[돌다리건너기](돌다리건너기.java)

한 칸 더 가야하는 것을 고려하는 문제 (작은 함정)

[최대부분증가수열](최대부분증가수열.java)

문제만 이해하면 괜찮았음!

[가장높은탑쌓기](가장높은탑쌓기.java)
```
public static int solution(ArrayList<block> blocks) {
    Collections.sort(blocks);
    int answer = 0;

    dy[0] = blocks.get(0).height;
    answer = dy[0];
    for (int i = 1; i < blocks.size(); i++) {
        int max = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (blocks.get(i).weight < blocks.get(j).weight && max < dy[j]) {
                max = dy[j];
            }
            dy[i] = max + blocks.get(i).height;
            answer = Math.max(dy[i], answer);
        }
    }
    return answer;
}
```
조건이 2개이면 한 조건으로 정렬하고\
다른 조건은 LIS방법으로 조건 확인하고 그 위에 올리는 느낌으로 접근한다