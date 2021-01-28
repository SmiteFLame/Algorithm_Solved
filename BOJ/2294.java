package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] money = new int[N];
        int[] DP = new int[K + 1];

        for(int i = 0; i < N; i++){
            money[i] = sc.nextInt();
        }
        Arrays.fill(DP,Integer.MAX_VALUE);

        DP[0] = 0;
        for(int i = 1; i <= K; i++){
            for(int j = 0; j < N; j++){
                if(i - money[j] >= 0 && DP[i - money[j]] != Integer.MAX_VALUE){
                    DP[i] = Math.min(DP[i], DP[i - money[j]] + 1);
                }
            }
        }
        if(DP[K] == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(DP[K]);
    }
}