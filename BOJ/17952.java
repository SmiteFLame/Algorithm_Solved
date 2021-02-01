package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    static class HW{
        int point;
        int time;
        HW(int point, int time) {
            this.point = point;
            this.time = time;
        }

        boolean work(){
            time--;
            return time <= 0 ? true : false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M, N, A, T, S = 0;
        Vector<HW> V = new Vector<>();
        N = sc.nextInt();
        for (int t = 0; t < N; t++) {
            M = sc.nextInt();
            if (M == 1) {
                A = sc.nextInt();
                T = sc.nextInt();
                V.add(new HW(A, T));
            }
            if(V.size() == 0) continue;
            if(V.lastElement().work()){
                S += V.lastElement().point;
                V.remove(V.size() - 1);
            }
        }
        System.out.print(S);
    }
}
