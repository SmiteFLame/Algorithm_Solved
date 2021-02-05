package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, answer = 0;
    static int arrow = 3;
    static int[][] map;
    static boolean[] isSelected;
    static Set<Pair> enemy = new LinkedHashSet<>();
    static StringTokenizer st = null;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int X;
        int Y;
        int level;

        Pair(int X, int Y, int level) {
            this.X = X;
            this.Y = Y;
            this.level = level;
        }


        public boolean equals(int X, int Y) {
            if (X == this.X && Y == this.Y) {
                return true;
            }
            return false;
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isSelected = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(io.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void makeCombi(int next, int cnt) {
        if (cnt == 3) {
            implement();
            return;
        }
        for (int i = next; i < M; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            makeCombi(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    public static boolean canMove(int X, int Y) {
        if (X >= 0 && X < N && Y >= 0 && Y < M) return true;
        return false;
    }

    public static boolean input(int X, int Y, int level){
        for(Pair p: enemy){
            if(p.equals(X, Y)){
                if(p.level == level){
                    return true;
                } else{
                    return false;
                }
            }
        }
        enemy.add(new Pair(X, Y, level));
        return true;
    }

    //    flag ����ؼ� �ߺ� �˻��ϱ�
    public static void implement() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (isSelected[i]) {
                list.add(i);
            }
        }
        enemy.clear();

        int max = 0;

        // ��� ������� ������ �� ���� ����
        for (int level = N - 1; level >= 0; level--) {

            // ��� �ü��� ���ؼ� �Ǵ�
            for (int ar : list) {

                // �ϴ� �ٷ� ���� �ؾ� �ϹǷ� ��ĭ�� ������ ��ĭ �̵�
                // 1. ���� ����� �� - �Ÿ��� ª�� ��
                L:
                for (int i = 0; i < D; i++) {

                    // 2. ���� ���ʿ� �ִ� �� ���� ������� �˻�
                    for (int j = -i; j <= i; j++) {
                        int x = level - (i - Math.abs(j));
                        if (canMove(x, ar + j)) {
                            if (map[x][ar + j] == 1) {
                                if(input(x, ar + j, level)) {
                                    break L;
                                }
                            }
                        }
                    }
                }
            }
        }
        answer = Math.max(enemy.size(), answer);
    }

    public static void main(String[] args) throws IOException {
        init();
        makeCombi(0, 0);
        System.out.println(answer);
    }
}
