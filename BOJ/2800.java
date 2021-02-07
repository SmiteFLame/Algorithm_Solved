package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String S;
    static Stack<Integer> stack = new Stack<>();
    static LinkedList<Pair> list = new LinkedList<>();
    static LinkedList<String> answer = new LinkedList<>();
    static PriorityQueue<Integer> pass = new PriorityQueue<>();
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int idx_first;
        int idx_second;

        Pair(int idx_first, int idx_second) {
            this.idx_first = idx_first;
            this.idx_second = idx_second;
        }
    }

    public static void init() throws IOException {
        S = io.readLine();
    }

    public static void implement() {
        for (int i = 0, end = S.length(); i < end; i++) {
            if (S.charAt(i) == '(') {
                stack.add(i);
            } else if (S.charAt(i) == ')') {
                list.add(new Pair(stack.pop(), i));
            }
        }
    }

    public static void subset() {
        for (int i = 1, endi = 1 << list.size(); i < endi; i++) {
            pass.clear();
            for (int j = 0, endj = list.size(); j < endj; j++) {
                if ((i & 1 << j) != 0) {
                    pass.offer(list.get(j).idx_first);
                    pass.offer(list.get(j).idx_second);
                }
            }
            makeString();
        }
    }

    public static void makeString() {
        String ans = "";
        for (int i = 0, end = S.length(); i < end; i++) {
            if (!pass.isEmpty() && pass.peek() == i) {
                pass.poll();
            } else {
                ans += S.charAt(i);
            }
        }
        if(!answer.contains(ans)) answer.offer(ans);
    }

    public static void print() {
        answer.sort(null);

        for(String s : answer){
            sb.append(s).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        subset();
        print();
    }
}
