package programmers.twenty_one.풀었던것.카카오코테;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainThree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] fee = {120, 0, 60, 591};
        String[] record = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
        System.out.println(Arrays.toString(solution(fee, record)));
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
        System.out.println((1 / 60) * 591);
        System.out.println(61 / 60);
        System.out.println((int) Math.ceil(154 / 10) * 10);

    }

    public static int[] solution(int[] fees, String[] records) {
        int standTime = fees[0];
        int standFee = fees[1];
        int perMin = fees[2];
        int perFee = fees[3];

        HashMap<String, Car> cars = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();
        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0];
            String[] HandM = time.split(":");
            int H = Integer.parseInt(HandM[0]);
            int M = Integer.parseInt(HandM[1]);
            String carNum = rec[1];
            if (!results.contains(carNum)) {
                results.add(carNum);
            }
            String InOut = rec[2];

            cars.putIfAbsent(carNum, new Car(H, M, InOut, 0,0));

            if (cars.containsKey(carNum)) {
                //  IN이면 바꿔주고 끝
                if (InOut.equals("IN")) {
                    Car post = cars.get(carNum);
                    // In 차 기록 넣어주기
                    cars.put(carNum, new Car(H, M, InOut,post.accumulateSum, post.charge));
                } else {
                    // OUT이면 계산하기
                    // 바꿔주기
                    Car post = cars.get(carNum);

                    // 계산
                    int accumulateH = H - post.H;
                    int accumulateM = M - post.M;
                    if (accumulateM < 0) {
                        accumulateM += 60;
                        accumulateH -= 1;
                    }
                    int accumulateSum = accumulateH * 60 + accumulateM;
                    cars.put(carNum, new Car(H, M, InOut, post.accumulateSum + accumulateSum, post.charge));

//
//                    // OUT 차 기록 넣어주기
//                    cars.put(carNum, new Car(H, M, InOut, post.charge));

                }
            }

        }

        // 다 끝나면 IN으로 기록된 녀석들 계산 마무리
        for (String car : cars.keySet()) {
            Car now = cars.get(car);
            if (now.InOut.equals("IN")) {
                int lastH = 23;
                int lastM = 59;

                int accumulateH = lastH - now.H;
                int accumulateM = lastM - now.M;
                if (accumulateM < 0) {
                    accumulateM += 60;
                    accumulateH -= 1;
                }
                int accumulateSum = accumulateH * 60 + accumulateM;
                cars.put(car, new Car(lastH, lastM, "OUT", now.accumulateSum + accumulateSum, now.charge));

            }
        }

        for (String carNum : cars.keySet()) {
            Car now = cars.get(carNum);
            //  누적이 기본시간 이하면 기본 요금 청구
            if (now.accumulateSum <= standTime) {
                now.charge += standFee;
            } else {
                // 누적이 기본시간 초과하면 기본 요금을 더해서
                now.charge += standFee;
                //  초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구
                int overTime = now.accumulateSum - standTime;
                double temp = (double) overTime;
                double per = (double) perMin;
                int timePer = (int) Math.ceil(temp / per);
                int overFee = timePer * perFee;

                now.charge += overFee;
            }

            cars.put(carNum, new Car(now.H, now.M, now.InOut, now.accumulateSum, now.charge));
        }

        int[] answer = new int[results.size()];
        int i = 0;
        Collections.sort(results);

        for (String carNum : results) {
            answer[i] = cars.get(carNum).charge;
            i++;
        }

        return answer;
    }

    private static class Car {
        int H;
        int M;
        String InOut;
        int accumulateSum;
        int charge;

        public Car(int h, int m, String inOut, int accumulateSum, int charge) {
            H = h;
            M = m;
            InOut = inOut;
            this.accumulateSum = accumulateSum;
            this.charge = charge;
        }


    }

}
