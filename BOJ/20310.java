package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static String S;
    static LinkedList<Integer> queue_0 = new LinkedList<>();
    static LinkedList<Integer> queue_1 = new LinkedList<>();
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void init() throws IOException {
        S = io.readLine();
    }

    public static void implement() {
        for(int i = 0, end = S.length(); i < end; i++){
            if (S.charAt(i) == '0') {
                queue_0.offer(i);
            } else {
                queue_1.offer(i);
            }
        }
    }

    public static void print(){
        // 0은 절반만 추가하기
        // 1은 앞에서 절반 제거 하고 추가하기
        for(int i = 0, end = queue_0.size() / 2; i < end; i++){
            queue_0.removeLast();
        }
        for(int i = 0, end = queue_1.size() / 2; i < end; i++){
            queue_1.removeFirst();
        }
        for(int i = 0, end = S.length() / 2; i < end; i++){
            if(queue_1.isEmpty()){
                sb.append('0');
                queue_0.poll();
            } else if(queue_0.isEmpty()){
                sb.append('1');
                queue_1.poll();
            } else if(queue_1.peek() > queue_0.peek()) {
                sb.append('0');
                queue_0.poll();
            } else{
                sb.append('1');
                queue_1.poll();
            }
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}
