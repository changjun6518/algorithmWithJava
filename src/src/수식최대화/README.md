프로그래머스/2020 카카오 인턴십/수식최대화
---


### 접근방법 / 알게된 점

1. 처음에는 수식과 숫자를 나누려했고
2. 계산하는 방법 함수 만들고
3. 우선순위를 정하려 했다

```
String[] numString = expression.split("\\+|\\*|-");
String[] operationString = expression.split("[0-9]+");
```
**split** 할때 |로 다중문자로 나눌수 있고 숫자들도 설정해서 나눌수 있음

```
static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r); //순열 출력을 위한 print 함수
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                per2(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
```
**순열**을 통해서 연산 기호 모든 경우의 수를 만들 수 있음
방법 2개 있는데   
모두 swap해보는 방법과 dfs하는 방법
둘다 알아야할 듯 하다  
낯설고 이해하기 힘들었다

### 한줄평

