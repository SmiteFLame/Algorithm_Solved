package jungol;

import java.util.Scanner;

public class Main_1411_¾çµ¿Çõ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] DP = new int[N + 1];
		DP[1] = 1;
		DP[2] = 3;
		for(int i = 3; i <= N; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2] * 2) % 20100529;
		}
		System.out.println(DP[N]);
		
		/*Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = 1, E = 3, T = 0;
		for(int i = 3; i <= N; i++) {
			T = (E + S * 2) % 20100529;
			S = E;
			E = T;
		}
		System.out.println(T);*/
	}
}