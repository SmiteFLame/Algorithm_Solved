package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, answer, left, right, sum, end;
    static boolean[] notPrimeNumber;
    static ArrayList<Integer> primeNumber = new ArrayList<>();
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));


    private static void init() throws IOException {
        N = Integer.parseInt(io.readLine());
        left = 0;
        right = 0;
        notPrimeNumber = new boolean[N + 1];

        notPrimeNumber[0] = true;
        notPrimeNumber[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!notPrimeNumber[i]) {
                for (int j = i * i; j <= N; j += i){
                    notPrimeNumber[j] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!notPrimeNumber[i]){
                primeNumber.add(i);
            }
        }
        end = primeNumber.size();
    }

    private static void implement() {
        while (true) {
            if (sum == N) {
                answer++;
                sum -= primeNumber.get(left++);
            } else if (sum < N) {
                if (right == end) break;
                sum += primeNumber.get(right++);
            } else {
                sum -= primeNumber.get(left++);
            }
        }
    }

    private static void print() {
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        init();
        implement();
        print();
    }
}