package jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1077_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, W;
	static jewelry[] jewelrys;
	static int[][] results;

	static class jewelry {
		int weight;
		int value;

		jewelry(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		results = new int[N + 1][W + 1];
		jewelrys = new jewelry[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			jewelrys[i] = new jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}

	private static void implement() {
		for (int item = 1; item <= N; item++) {
			for (int w = 1; w <= W; w++) {
				if(w - jewelrys[item].weight >= 0) {
					results[item][w] = Math.max(results[item - 1][w], results[item][w - jewelrys[item].weight] + jewelrys[item].value);
				} else {
					results[item][w] = results[item - 1][w];
				}
			}
		}
	}

	private static void print() throws IOException {
		System.out.println(results[N][W]);
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
