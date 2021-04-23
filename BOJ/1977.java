package justonly;

import java.util.Scanner;

public class Main_1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt() - 1;
		int E = sc.nextInt();
		S = (int) Math.sqrt(S);
		E = (int) Math.sqrt(E);
		if (S >= E) {
			System.out.println(-1);
		} else {
			int sum = 0;
			for(int i = S + 1; i <= E; i++) {
				sum += i * i;
			}
			System.out.println(sum);
			System.out.println((S + 1) * (S + 1));
		}
	}
}
