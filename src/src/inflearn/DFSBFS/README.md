# DFS / BFS

[합이같은부분집합](합이같은부분집합.java)
```
public static void DFS(int[] arr, int sum, int level) {
    if (flag) {
        return;
    }
    if (level == numberCount) {
        if ((totalSum - sum) == sum) {
            answer = "YES";
            flag = true;
        }
    } else {
        DFS(arr, sum + arr[level], level + 1);
        DFS(arr, sum, level + 1);
    }
}
```
배열에 넣고 한칸씩 두갈래로 진행하는 DFS를 만들면 됨\
flag 넣어서 retrun하게끔 설계하고\
default로 answer에 NO 넣어두고 조건만족할때 YES로 바꿈