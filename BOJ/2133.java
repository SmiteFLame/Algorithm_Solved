package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int N;
    static long MOD = 1000000007;
    static long[] DP;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));


    private static void init() throws IOException {
        N = Integer.parseInt(io.readLine());
        DP = new long[N + 1];
    }



    private static long implement(int K) {
        if(K == 0) return 1;
        if(K == 1) return 0;
        if(K == 2) return 3;
        if(DP[K] != 0) return DP[K];

        DP[K] = 3 * implement(K - 2);
        for(int i = 4; i <= K; i += 2){
            DP[K] += 2 * implement(K - i);
        }
        DP[K] %= MOD;
        return DP[K];
    }


    public static void main(String[] args) throws IOException {
        init();
        System.out.print(implement(N));
    }
}