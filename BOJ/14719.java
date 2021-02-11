package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int H, W, max, sum, sumtemp;
    static int[] data;
    static int[] flood;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        data = new int[W];
        flood = new int[W];
        st = new StringTokenizer(io.readLine());
        for (int i = 0; i < W; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        sum = 0;
    }

    private static void implement() {
        // 왼쪽 부터 오른쪽 으로 구현
        max = data[0];
        sumtemp = 0;
        for(int i = 1; i < W; i++){
            if(data[i] >= max) {
                max = data[i];
            }
            flood[i] = (max - data[i]);
        }


        // 오른쪽 부터 왼쪽 으로 구현
        max = data[W - 1];
        sumtemp = 0;
        for(int i = W - 1; i >= 0; i--){
            if(data[i] >= max) {
                max = data[i];
            }
            flood[i] = Math.min(flood[i], max - data[i]);
        }

        for(int i = 0; i < W; i++){
            sum += flood[i];
        }
    }

    private static void print() {
        System.out.print(sum);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}