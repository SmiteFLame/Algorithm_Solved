package justonly;

import java.util.Scanner;

public class Main_6588 {

	public static void main(String[] args) {
		boolean[] notPrimeNumber = new boolean[1000001];
		for(int i = 2; i <= 1000000; i++) {
			if(notPrimeNumber[i]) continue;
			for(int j = i * 2; j <= 1000000; j += i) {
				notPrimeNumber[j] = true;
			}
		}
		Scanner sc = new Scanner(System.in);
		next:
		while(true) {
			int N = sc.nextInt();
			if(N == 0) break;
			boolean find = false;
			for(int F = 3; F < 1000000; F += 2) {
				if(N - F < F) break;
				if(notPrimeNumber[F] || notPrimeNumber[N - F]) continue;
				System.out.println(N + " = " + F + " + " + (N - F));
				continue next;
			}
			
			System.out.println("Goldbach's conjecture is wrong.");			
		}

	}

}
