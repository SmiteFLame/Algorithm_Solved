package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] data;
    static int[] DP;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];

        st = new StringTokenizer(io.readLine());
        for(int i = 0 ; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        DP = new int[N + 1];

        for(int i = 1; i <= N; i++){
            DP[i] = DP[i - 1] + data[i - 1];
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(io.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            sb.append(DP[Y] - DP[X - 1]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb.toString());
    }
}
