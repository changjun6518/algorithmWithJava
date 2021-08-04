### Greedy Algorithm

[씨름선수](씨름선수.java)
```
Collections.sort(players);
public static void greedy(ArrayList<Point> players) {
    int max = Integer.MIN_VALUE;
    for (Point player : players) {
        if (max < player.y) {
            count++;
            max = player.y;
        }
    }
}
```
우선 키부터 정렬하고 몸무게만 비교해서 해당하는지 체크하면 되는 문제

[회의실배정](회의실배정.java)

가볍게 Comparable 사용해서 풀 수 있었다

[결혼식](결혼식.java)
```
for (int i = 0; i < n; i++) {
    times.add(new Time("start", sc.nextInt()));
    times.add(new Time("end", sc.nextInt()));
}
```
들어오는 거 하나하나를 따로 받아서 해석할 수 있다\
char로 state를 오름차순 정리 할 수 있다
