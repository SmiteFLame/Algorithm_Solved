package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, nx, ny, min = Integer.MAX_VALUE;
    static String S;
    static int[][] visited;
    static boolean[][] map;
    static int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<info> queue = new LinkedList<>();
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class info {
        int X;
        int Y;
        int cnt;
        int smash;

        info(int X, int Y, int cnt, int smash) {
            this.X = X;
            this.Y = Y;
            this.cnt = cnt;
            this.smash = smash;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            S = io.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = S.charAt(j) == '0' ? false : true;
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        visited[0][0] = 0;

    }

    private static boolean outOfArea(int X, int Y) {
        if (X >= 0 && X < N && Y >= 0 && Y < M) {
            return false;
        }
        return true;
    }


    private static void implement() {
        queue.offer(new info(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            info newinfo = queue.poll();
            if(newinfo.X == N - 1 && newinfo.Y == M - 1){
                min = newinfo.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = newinfo.X + NEWS[i][0];
                ny = newinfo.Y + NEWS[i][1];

                if (outOfArea(nx, ny)) continue;

                if(visited[nx][ny] <= newinfo.smash) continue;

                if (map[nx][ny]) {
                    if(newinfo.smash == 0){
                        visited[nx][ny] = newinfo.smash + 1;
                        queue.offer(new info(nx, ny, newinfo.cnt + 1, newinfo.smash + 1));
                    }
                } else{
                    visited[nx][ny] = newinfo.smash;
                    queue.offer(new info(nx, ny, newinfo.cnt + 1, newinfo.smash));
                }
            }
        }
    }

    private static void print() {
        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}