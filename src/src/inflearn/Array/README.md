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
