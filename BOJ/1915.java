package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        int[][] map = new int[N][M];
        int[][] DP = new int[N][M];
        String S;
        for (int i = 0; i < N; i++) {
            S = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = S.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                int min = Integer.MAX_VALUE;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    min = Math.min(min, DP[i - 1][j]);
                    min = Math.min(min, DP[i][j - 1]);
                    min = Math.min(min, DP[i - 1][j - 1]);
                }
                if(min == Integer.MAX_VALUE){
                    DP[i][j] = 1;
                }else{
                    DP[i][j] = min + 1;
                }
                max = Math.max(max, DP[i][j]);
            }
        }
        System.out.print(max * max);
    }
}