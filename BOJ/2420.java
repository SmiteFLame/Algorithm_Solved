package justonly;

import java.util.Scanner;

public class Main_2420 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong() - sc.nextLong();
		System.out.println(N > 0 ? N : -N);
	}
}
