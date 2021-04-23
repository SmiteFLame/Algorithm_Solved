package justonly;

import java.util.Scanner;

public class Main_10974 {

	static int N;
	static int[] data;

	private static void subset(int cnt, int flag) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			data[cnt] = i + 1;
			subset(cnt + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N];
		subset(0, 0);
	}
}
