package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, P, X, Y, answer;
    static Stack<Integer>[] stack;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        stack = new Stack[7];
        for(int i = 0; i < 7; i++){
            stack[i] = new Stack<>();
        }
    }



    private static void implement() throws IOException{
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(io.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            while(!stack[X].isEmpty()){
                if(stack[X].peek() < Y){
                    stack[X].push(Y);
                    answer++;
                    break;
                } else if(stack[X] .peek() > Y){
                    stack[X].pop();
                    answer++;
                } else{
                    break;
                }
            }

            if(stack[X].isEmpty()){
                stack[X].push(Y);
                answer++;
            }
        }
    }

    private static void print(){
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}