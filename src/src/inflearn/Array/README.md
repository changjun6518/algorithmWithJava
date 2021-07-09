#배열

[큰수출력하기](큰수출력하기.java)
```
nextInt()
```
아직 입력받기에 미숙한 듯하다
해설은 ArrayList에 추가하는 식으로 하였다..

[보이는학생](보이는학생.java)

쉽게 풀 수 있는 난이도였다.

[가위바위보](가위바위보.java)
```
for (int i = 0; i < num; i++) {
            if (ArrA[i] == ArrB[i]) {
                System.out.println("D");
            } else if (ArrA[i] == 1 && ArrB[i] == 3) {
                System.out.println("A");
            } else if (ArrA[i] == 2 && ArrB[i] == 1) {
                System.out.println("A");
            } else if (ArrA[i] == 3 && ArrB[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
```
가위바위보의 경우의 수를 따지는 방법을 생각하지 못했다..\
비길때 -> A가 이길때 -> 나머지~!

[피보나치수열](피보나치수열.java)

so easy

[소수](소수.java)
```
int[] ans = new int[num+1];
for (int j = i; j <= num; j = j + i) {}
```
입력받은 숫자만큼 미리 배열을 만들고\
포문으로 배수 마다 확인할 수 있게끔 한다.

[뒤집은소수](뒤집은소수.java)
```
String s1 = new StringBuilder(s).reverse().toString();
arr[i] = Integer.parseInt(s1);
```
난 이렇게 숫자를 뒤집었는데 강의에서는 곱셈과 더하기 나눗셈으로 뒤집었다...\
알면 좋은 내용이였다..

[점수계산](점수계산.java)
```
if(arr[i] == 1) {
    cnt++;
    answer += cnt;
}
else cnt = 0;
```
나는 다소 어렵게 풀었지만 매우 간단한 코드로 풀 수 있었다.

[등수구하기](등수구하기.java)

쉽게 풀 수 있었다.

[격자판최대합](격자판최대합.java)
```
Math.max();
sum += arr[i][n-i-1];
```
Math.max를 사용해서 최대값을 구해보자\
반대 대각선을 고려하지 않았다... 조심하자

[봉우리](봉우리.java)
```
if (arr[i - 1][j] < now && arr[i + 1][j] < now && arr[i][j + 1] < now && arr[i][j - 1] < now) 
```
나는 이렇게 풀었지만..\
음 dx,dy주고 경계값 확실히 처리해줘야한다.. 어색하긴하다