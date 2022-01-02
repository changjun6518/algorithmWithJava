package programmers.twenty_one.문제풀이;

public class Solution2 {
    static int[] dy;

    public static int solution(int numOfStairs) {
        dy = new int[numOfStairs+1];
        dy[1] = 1;
        if(numOfStairs==1){
            return dy[1];
        }
        dy[2] = 2;
        if(numOfStairs==2){
            return dy[2];
        }
        dy[3] = 4;
        if(numOfStairs==3){
            return dy[3];
        }

        for(int i=4; i<=numOfStairs; i++){
            dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
        }

        return dy[numOfStairs];
    }

    public static void main(String[] args) {
        int solution = solution(1);
        System.out.println(solution);
    }
}
