package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, nx, ny, sumWhite, sumBlue;
    static int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String S;
    static Queue<int[]> queue = new LinkedList<>();
    static char[][] map;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    private static void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            S = io.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = S.charAt(j);
            }
        }
    }

    private static boolean canNotMove(int X, int Y) {
        if (X >= 0 && X < M && Y >= 0 && Y < N) {
            return false;
        }
        return true;
    }

    private static void BFS(int X, int Y) {
        char nowChar = map[X][Y];
        int cnt = 1;

        queue.offer(new int[]{X, Y});
        map[X][Y] = 'X';

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = temp[0] + NEWS[i][0];
                ny = temp[1] + NEWS[i][1];
                if (canNotMove(nx, ny) || map[nx][ny] != nowChar) continue;
                map[nx][ny] = 'X';
                queue.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        if(nowChar == 'W') sumWhite += (cnt * cnt);
        else sumBlue += (cnt * cnt);
    }


    private static void implement() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 'X') {
                    BFS(i, j);
                }
            }
        }
    }

    private static void print() {
        System.out.print(sumWhite + " " +sumBlue);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}