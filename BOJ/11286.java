package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N, X;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) - Math.abs(o2) > 0){
                return 1;
            } else if(Math.abs(o1) - Math.abs(o2) < 0){
                return -1;
            } else{
                return o1 - o2;
            }
        }
    });

    private static void init() throws IOException {
        N = Integer.parseInt(io.readLine());
    }


    private static void implement() throws IOException {
        for(int i = 0; i < N; i++){
            X = Integer.parseInt(io.readLine());
            if(X == 0) sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            else queue.offer(X);
        }
    }

    private static void print(){
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}