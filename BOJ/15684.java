package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, X, Y, temp, max = 4;
    static boolean[][] map;
    static int[] last;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];
        last = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(io.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            map[X][Y] = true;
            map[X][Y + 1] = true;
        }

    }

    public static boolean isAnswer() {

        for (int i = 1; i <= N; i++) {
            last[i] = i;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j]) {
                    temp = last[j];
                    last[j] = last[j + 1];
                    last[j + 1] = temp;
                    j++;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (last[i] != i) return false;
        }
        return true;
    }

    public static void implement(int cnt, int height, int index) {
        if (isAnswer()){
            max = Math.min(cnt, max);
            return;
        }

        for (int i = height; i <= H; i++) {
            for (int j = index; j < N; j++) {
                if (map[i][j] || map[i][j + 1]) continue;
                if(cnt >= Math.min(max, 3)) continue;
                map[i][j] = true;
                map[i][j + 1] = true;
                implement(cnt + 1, i, j + 2);
                map[i][j] = false;
                map[i][j + 1] = false;
            }
            index = 1;
        }
    }

    public static void print() {
        System.out.print(max == 4 ? -1 : max);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement(0, 1, 1);
        print();
    }
}
