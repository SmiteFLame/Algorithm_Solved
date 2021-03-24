package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_2839_¾çµ¿Çõ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] DP = new int[N + 1];
		Arrays.fill(DP, -1);
		
		if(N >= 3) DP[3] = 1;
		if(N >= 5) DP[5] = 1;
		
		for(int i = 6; i <= N; i++){
			if(DP[i - 3] != -1 && DP[i - 5] != -1) DP[i] = DP[i - 3] < DP[i - 5] ? DP[i - 3] + 1 : DP[i - 5] + 1;
			else if(DP[i - 3] != -1) DP[i] = DP[i - 3] + 1;
			else if(DP[i - 5] != -1) DP[i] = DP[i - 5] + 1;
		}
		System.out.println(DP[N]);
	}
}
