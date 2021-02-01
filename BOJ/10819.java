package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, M = 0;
    static int[] D;
    static boolean[] B;
    static Stack<Integer> S = new Stack<>();

    public static void count(){
        int sum = 0;
        for(int i = 1; i < N; i++){
            sum += Math.abs(D[S.get(i - 1)] - D[S.get(i)]);
        }
        M = Math.max(sum, M);
    }

    public static void Combi(int C){
        if(C == N){
            count();
            return;
        }

        for(int i = 0; i < N; i++){
            if(B[i]) continue;
            B[i] = true;
            S.add(i);
            Combi(C + 1);
            S.pop();
            B[i] = false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N];
        B = new boolean[N];
        for(int i = 0; i < N; i++){
            D[i] = sc.nextInt();
        }
        Combi(0);
        System.out.print(M);
    }
}
