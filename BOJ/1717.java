package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] head;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        head = new int[N + 1];

        for(int i = 0; i <= N; i++){
            head[i] = i;
        }
    }

    private static int findhead(int X){
        while(X != head[X]){
            X = head[X];
        }
        return X;
    }

    private static void union(int X, int Y){
        X = findhead(X);
        Y = findhead(Y);
        if(X != Y) {
            head[Y] = X;
        }
    }

    private static void check(int X, int Y){
        if(findhead(X) == findhead(Y)) sb.append("YES");
        else sb.append("NO");
        sb.append("\n");
    }


    private static void implement() throws IOException {
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(io.readLine());
            if(st.nextToken().charAt(0) == '0'){
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else{
                check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void print() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}