package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] data;
    static int[] numbers;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        numbers = new int[M];
        st = new StringTokenizer(io.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
    }

    private static void permutation(int idx, int next) {
        if (idx == M) {
            print();
            return;
        }
        for(int i = next; i < N; i++){
            numbers[idx] = i;
            permutation(idx + 1, i);
        }
    }

    public static void print(){
        for(int i = 0; i < M; i++){
            sb.append(data[numbers[i]]).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        init();
        permutation(0, 0);
        System.out.println(sb.toString());
    }
}
