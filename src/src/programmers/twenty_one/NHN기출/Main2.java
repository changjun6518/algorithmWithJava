package programmers.twenty_one.NHN기출;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    static int[] arr;
    public static void main(String[] args) {
        int n = 5;
        int jump = 3;
        arr = new int[n * n];
        arr[0] = 1;
        fillArray(n, jump);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void fillArray(int n,int jump){
        int index = 0;
        int check = 0;
        int level = 1;
        while(level<n*n-1){
            System.out.println("?");
            if(index==n*n-1){
                int i = 0;
                while (true) {
                    if (arr[i] == 0) {
                        index = i-1;
                        break;
                    }
                    i++;
                }
            }
            if(arr[index+1] == 0){
                check++;
                index++;
            }
            if(check == jump){
                arr[index] = ++level;
                check = 0;
            }
        }
    }


}
