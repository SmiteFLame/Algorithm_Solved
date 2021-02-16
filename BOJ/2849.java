package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2839_¾çµ¿Çõ {
	static int N, max = -1;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	
	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
	}
	
	private static void implement() {
		for(int i = N / 5, end = 0; i >= end; i--) {
			int temp = N - 5 * i;
			if(temp % 3 == 0) {
				max = i + temp / 3;
				return;
			}
		}
	}
	
	private static void print() {
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
