#문자열

[문자찾기](문자찾기.java)  
```
sc.next().charAt(index);
```
charAt(index)로 문자열하나 가져옴
```
str.toUpperCase();
Character.toUpperCase(char c);

for(char x : str.toCharArray()){}
```
문자열은 바로 함수, 문자는 character써서 해야함   
iter쓰고싶으면 str을 문자배열로 바꿔줘야함

[대소문자변환](대소문자변환.java)   
처음 접근 => 정규표현식으로 소문자인지 대문자인지 확인   
그리고 대소문자 변환해주는 함수 만들었음   
그리고 static 스프링 만들어서 추가해서 결과 만들려고함
```
Character.isLowerCase(c)
```
Charector에 소문자 대문자 인지 확인하는 함수가 있다..   

[문장속단어](문장속단어.java)
```
String 메소드
indexof()
subString()
```
띄어쓰기 만나는 지점의 인덱스를 알아내고 그 인덱스로부터   
subString을 통해 잘라내면서 길이 파악     

[단어뒤집기](단어뒤집기.java)
```
String[] arr = new String[N];
String temp = new StringBuilder(s).reverse().toString();
char[] s = str.toCharArray();
```
String[] 초기화는 위 처럼..   
String은 한번 만들면 불변하기 때문에 변경할 경우 계속해서 새로운 객체를 생성\
StringBuilder는 변경가능하기때문에 스트링보다 가볍다 메모리 적게 쓰니까!\
이거 말구 문자를 toCharArray써서 인덱스 맨처음이랑 끝이랑 바꾸면서 하는 것도 방법!\

[특정문자뒤집기](특정문자뒤집기.java)
```
!Character.isAlphabetic(c[lt])
String.valueof(char c[])
```
알파벳인지 아닌지 확인
char 배열을 String으로 만들어줌

[중복문자제거](중복문자제거.java)
```
i == str.indexOf(str.charAt(i))
```
중복문자제거할때 문자가 나온 인덱스와 indexOf 나온 인덱스가 같으면 처음이다...\
그리고 그걸 처음이라고 알았을 때 String에다가 +로 더해주면 되는 간단한 문제..\
나는 왜 char[]배열을 만들어 추가하려 한것인가? 가볍게.. 생각\
그리고 charAt도 까먹었었다 쓰다보면 익숙해질것

[회문문자열](회문문자열.java)
```
str.equalsIgnoreCase(strReverse);
```
문자열 비교할때 대소문자 구분없이 같은지 다른지 판단하는 메소드

[유효한팰린드롬](유효한팰린드롬.java)
```
str.replaceAll("[^A-Z]", "");
```
정규표현식을 이용한 특정문자 제거\
^는 A-Z가 아닌것을 의미!

[숫자만추출](숫자만추출.java)
```
Character.isDigit()
```
숫자인지 확인! (나는 replace 정규표현식으로 풀었음)

[가장짧은문자거리](가장짧은문자거리.java)
```
str.charAt(i)
answer[i] = Math.min(p, answer[i]);
```
내가 자꾸 문자열에서 하나하나 뜯어볼때 toCharArray를 쓰려하는데\
charAt으로 인덱스로 쉽게 접근할 수 있어서 코드가 간편해진다\
그리고 Math 모듈?을 사용해서 가벼운 연산 비교는 사용하자

[문자열압축](문자열압축.java)\
문제해결능력을 요구하는 문제

[압축](압축.java)
```
String temp = str.substring(0,7).replace('#', '1').replace('*', '0');
int number = Integer.parseInt(temp, 2);
answer += (char) number;
str = str.substring(7);
```
substring으로 문자열 자르기\
replace로 문자열 대체하기\
Integer.parseInt로 진수 바꾸기\
(char)캐스팅으로 아스키문자로 바꾸기
