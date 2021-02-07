package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(io.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void implement(){

        for(int x = 0; x < N; x++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = Math.min(map[i][j], map[i][x] + map[x][j]);
                }
            }
        }
    }

    public static void print() throws IOException{
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(io.readLine());
            if(map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] <=Integer.parseInt(st.nextToken())){
                sb.append("Enjoy other party");
            } else{
                sb.append("Stay here");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
        System.out.println(sb.toString());
    }
}
