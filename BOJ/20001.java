package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String S;
    static int stack = 0;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        io.readLine();
        while(true){
            S = io.readLine();
            if(S.length() > 4) break;
            if(S.length() == 2){
                stack++;
            } else{
                stack = stack == 0? stack + 2 : stack - 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        if(stack == 0) System.out.print("绊公坷府具 荤尔秦");
        else System.out.print("叁备");
    }
}
