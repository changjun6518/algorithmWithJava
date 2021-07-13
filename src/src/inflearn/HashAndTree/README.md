# HashMap, TreeSet (해쉬, 정렬지원 Set)

[학급회장](학급회장.java)
```
HashMap<Character, Integer> map = new HashMap<>();
map.put()
map.getOrDefault()  <--- 중요
map.size()
map.remove()
map.containsKey()

```
처음 사용해 보았다...\
기능들이 많더라... 자꾸 사용하면 익숙해질것임

[아나그램](아나그램.java)
```
mapA.put(c, mapA.getOrDefault(c, 0) + 1);
map.containsKey(c);
```
나는 두개의 해쉬맵 만들고 비교해서 하나라도 다르면 NO리턴\
해설은 한개의 해쉬맵 만들고 더하고 빼서 0이 아니면 NO 다른 key값있으면 NO

[매출액의종류](매출액의종류.java)
```
map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
map.replace(arr[lt], map.get(arr[lt]) - 1);
if (map.get(arr[lt]) == 0) {
    map.remove(arr[lt]);
}
```
++을 아무데나 남발하지 마라...\
그리고 난 replace를 사용했지만 그냥 put해서 -해도 되네