import java.io.IOException;

public class 키패드만들기 {
    public static void main(String[] args) throws IOException {
//        테스트 케이스 돌려보기
//        더 깔쌈한 방법은 없을까?
        int[] numbers;
        numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String solution = solution(numbers, hand);
        System.out.printf("%s", solution);

    }
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftIndex = 10;
        int rightIndex = 12;

        for(int number : numbers){
            if(number==1||number==4||number==7){
                sb.append("L");
                leftIndex = number;
            }
            else if(number==3||number==6||number==9){
                sb.append("R");
                rightIndex = number;
            }
            else{
                int lLength = getLength(leftIndex, number);
                int rLength = getLength(rightIndex, number);
                if(lLength < rLength){
                    sb.append("L");
                    leftIndex = number;
                }
                else if(lLength > rLength){
                    sb.append("R");
                    rightIndex = number;
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        rightIndex = number;
                    }
                    else{
                        sb.append("L");
                        leftIndex = number;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static int getLength(int handIndex, int number){
        handIndex = (handIndex == 0) ? 11 : handIndex;
        number = (number == 0) ? 11 : number;

        int x = (number-1) % 3;
        int y = (number-1)/3;

        int xHand = (handIndex-1) % 3;
        int yHand = (handIndex-1) / 3;

        return Math.abs(x-xHand) + Math.abs(y-yHand);
    }

}

