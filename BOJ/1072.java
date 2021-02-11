package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X, Y, Z, L, R, M, A;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Y * 100 / X + 1;
        L = 1;
        R = 1000000000;
        A = -1;
    }

    private static void implement(){
        while(L <= R){
            M = (L + R) / 2;
            if(Z <= (Y + M) * 100 / (X + M)){
                R = M - 1;
                A = M;
            } else{
                L = M + 1;
            }
        }
    }
    
    private static void print(){
        System.out.println(A);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}