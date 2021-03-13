package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2629 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, T;
	static int[] data;
	static boolean[][] subsetData;
	static Set<Integer> set = new HashSet<>();

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N];

		int sum = 0;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}

		subsetData = new boolean[N][sum + 1];
	}

	private static void subset(int idx, int sum) {
		if (idx == N) {
			set.add(sum);
			return;
		}
		
		if (subsetData[idx][sum])
			return;
		
		subsetData[idx][sum] = true;
		subset(idx + 1, sum + data[idx]);
		subset(idx + 1, sum);
		subset(idx + 1, Math.abs(sum - data[idx]));
	}

	private static void implement() {
		subset(0, 0);
	}

	private static void print() throws IOException {
		T = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < T; i++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) {
				ot.write("Y ");
			} else {
				ot.write("N ");
			}
		}
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
