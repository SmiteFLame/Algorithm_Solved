package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2576 {
	static int N, min = Integer.MAX_VALUE, sum = 0;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void init() throws IOException {
		for (int i = 0; i < 7; i++) {
			N = Integer.parseInt(io.readLine());
			if (N % 2 == 0)
				continue;
			sum += N;
			min = N < min ? N : min;
		}
	}

	private static void print() throws IOException {
		if (sum == 0) {
			ot.write("-1");
		} else {
			ot.write(sum + "\n");
			ot.write(min + "\n");
		}
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		print();
	}

}
