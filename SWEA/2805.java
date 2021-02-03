package swea;

import java.util.Scanner;

public class Solution_D3_2805_¾çµ¿Çõ {
	static int T, N, countNum, K;
	static String S;
	static boolean overHalf = false;
	static StringBuilder st = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			countNum = 0;
			
			overHalf = false;
			
			K = 1;
			
			for (int i = 0; i < N; i++) {
				S = sc.next();
				for (int j = 0; j < K; j++) {
					countNum += (S.charAt(j + (N - K) / 2) - '0');
				}

				if(K == N) overHalf = true;
				
				if (overHalf)
					K -= 2;
				else
					K += 2;
			}
			
			st.append("#" + test_case + " " + countNum + "\n");
		}
		
		System.out.println(st.toString());
	}
}
