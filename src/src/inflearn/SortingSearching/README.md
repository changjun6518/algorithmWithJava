# 정렬, 이분검색과 결정알고리즘

[선택정렬](선택정렬.java)

선택정렬 : 전체 체크해서 제일 작은 것을 앞에서부터 순서대로 바꿔줌\
풀이 그대로 품!

[버블정렬](버블정렬.java)

버블정렬 : 처음부터 2개씩 큰거를 뒤로 보내는 식으로 계속해서\
마지막에 큰것을 고정시는 방식

[삽입정렬](삽입정렬.java)

key값을 정하고 내려오면서 자기보다 크면 한칸씩 미는 방식

[LeastRecentlyUsed](LeastRecentlyUsed.java)

어려워 보였는데 차근차근 해냈다 기분좋구만

[중복확인](중복확인.java)
```
Arrays.sort()
```
정렬한 다음에 바로 옆에 있는 숫자가 같은지 체크하는 식으로 확인한다\
나는 다르게 풀었는데... 이게 시간이 더 짧아 보인다\
해쉬맵 써서 같은 key값 있으면 return하도록 해도 된다

[장난꾸러기](장난꾸러기.java)
```
int[] temp = arr.clone();
```
깊은 복사를 해야 새로 만든 temp가 바뀌지 않는다...!

[좌표정렬](좌표정렬.java)
```
class Point implements Comparable<Point> {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else return this.x - o.x;
    }
}

Collections.sort(points);
```
Comparable라는 인터페이스를 구현하는 것!?\
compareTo메소드를 오버라이딩해서 오름차순이면 this - object가 음수가 되도록 리턴!\
좋은 걸 배웠다...

[이분검색](이분검색.java)

이분검색... mid , start, end로 컨트롤!!

[뮤직비디오_결정알고리즘](뮤직비디오_결정알고리즘.java)
```
int lt = Arrays.stream(arr).max().getAsInt();
int rt = Arrays.stream(arr).sum();
```
Arrays.stream()을 사용해서! min, max, sum을 구할 수 있음

[마구간정하기](마구간정하기.java)

이것도 결정알고리즘이였는데 풀 수 있었음