package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int N, L;
    static String S, T, R;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));


    private static void init() throws IOException {
        N = Integer.parseInt(io.readLine());
    }



    private static void implement() throws IOException {
        S = io.readLine();
        L = S.length();
        for(int i = 1; i < N; i++){
            T = io.readLine();
            R = "";
            for(int j = 0; j < L; j++){
                if(S.charAt(j) == T.charAt(j)) R += S.charAt(j);
                else R += '?';
            }
            S = R;
        }
    }

    private static void print(){
        System.out.print(S);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}