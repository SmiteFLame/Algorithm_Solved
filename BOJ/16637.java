package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, max = Integer.MIN_VALUE, leftNum;
    static String S;
    static int[] number, cloneNum;
    static char[] operator, cloneOper;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));


    private static void init() throws IOException {
        N = Integer.parseInt(io.readLine());
        S = io.readLine();
        number = new int[N / 2 + 1];
        operator = new char[N / 2];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) number[i / 2] = S.charAt(i) - '0';
            else operator[i / 2] = S.charAt(i);
        }
    }

    private static int opeatorResult(int L, int R, char C) {
        if (C == '+') {
            return L + R;
        } else if (C == '-') {
            return L - R;
        } else {
            return L * R;
        }
    }

    // ��ȣ ����� �� ���� ����
    // �켱 ������ ���� 1�� ���� �� �ְ� ��� ��� ���� �� �ִ�.
    private static void subset() {
        for (int i = 0, end = 1 << (N / 2); i < end; i++) {
            if ((i & i << 1) == 0) {
                implement(i);
            }
        }
    }

    private static void implement(int subset) {
        // 1�� �� ���� ���� ���
        cloneNum = Arrays.copyOf(number, N / 2 + 1);
        cloneOper = Arrays.copyOf(operator, N / 2);

        for (int i = 0, end = N / 2; i < end; i++) {
            if ((subset & 1 << i) == 1 << i) {
                cloneNum[i] = opeatorResult(cloneNum[i], cloneNum[i + 1], cloneOper[i]);
                cloneOper[i] = 'P';
            }
        }
        // 0�� �� ���߿� ���
        for (int i = 0, end = N / 2; i < end; i++) {
            if ((subset & 1 << i) != 1 << i) {
                leftNum = i;
                while(leftNum > 0 && cloneOper[leftNum - 1] == 'P'){
                    leftNum--;
                }
                cloneNum[leftNum] = opeatorResult(cloneNum[leftNum], cloneNum[i + 1], cloneOper[i]);
                cloneOper[i] = 'P';

            }
        }
        max = Math.max(max,cloneNum[0]);
    }

    private static void print() {
        System.out.print(max);
    }

    public static void main(String[] args) throws IOException {
        init();
        subset();
        print();
    }
}