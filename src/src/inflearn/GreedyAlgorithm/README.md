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

[최대수스케쥴](최대수스케쥴.java)
```
 public static void greedy(ArrayList<Schedule> schedules) {
    Collections.sort(schedules);
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    int j = 0;
    for (int i = max; i >= 1; i--) {
        for (; j < n; j++) {
            if (schedules.get(j).limitDay < i) {
                break;
            }
            pQ.offer(schedules.get(j).price);
        }
        if (!pQ.isEmpty()) {
            sum += pQ.poll();
        }
    }
}
```
PriorityQueue를 사용하는 문제\
int j = 0;\
for (int i = max; i >= 1; i--) {\
for (; j < n; j++)\
for문 돌릴 때 2중 포문인데 저렇게 할 수 있음

[다익스트라](다익스트라.java)
```
public static void solution(int v) {
    PriorityQueue<Edge> pQ = new PriorityQueue<>();
    pQ.offer(new Edge(v, 0));
    dis[v] = 0;
    while (!pQ.isEmpty()) {
        Edge temp = pQ.poll();
        int now = temp.vex;
        int cost = temp.cost;
        if (dis[now] < cost) {
            continue;
        }
        for (Edge edge : graph.get(now)) {
            if (edge.cost + cost < dis[edge.vex]) {
                dis[edge.vex] = edge.cost + cost;
                pQ.offer(new Edge(edge.vex, edge.cost + cost));
            }
        }
    }
}
```
음 솔직히 잘 모르겠는데 이건 반복하면서 이해하도록

[친구인가](친구인가.java)

union과 find -> 서로소를 만드는 함수...!

[원더랜드](원더랜드.java)
```
public static void minSpanningTree(ArrayList<Edge> graph) {
    Collections.sort(graph);
    for (Edge edge : graph) {
        int fa = find(edge.startNode);
        int fb = find(edge.endNode);
        if (fa != fb) {
            union(edge.startNode, edge.endNode);
            sum += edge.cost;
        }
    }
}
```
크루스칼<br>
union&find로 푸는 문제\
비용이 제일 작은 것 부터 체크해 나가면서 같은 집합인지 확인만 해주면 끝

[원더랜드2](원더랜드2.java)
```
PriorityQueue<Edge> pQ = new PriorityQueue<>();
pQ.offer(new Edge(1, 0));
while (!pQ.isEmpty()) {
    Edge tmp = pQ.poll();
    int ev = tmp.nextNode;
    if (ch[ev] == 0) {
        ch[ev] = 1;
        sum += tmp.cost;
        for (Edge edge : graph.get(ev)) {
            if (ch[edge.nextNode] == 0) {
                pQ.offer(new Edge(edge.nextNode, edge.cost));
            }
        }
    }
}
```
프림\
우선순위 큐로 푸는 문제\
노드에 방문 여부 체크하면서 노드에 붙어 있는 노드들 모두 우선순위 큐에 넣고\
제일 작은 값 꺼내서 체크해나가는 방식