package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] data;
	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 3; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void implement() {
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for(int x = 0; x < 3; x++) {
					if(j == x) continue;
					min = data[i - 1][x] < min ? data[i - 1][x] : min; 
				}
				data[i][j] += min;
			}
		}
	}

	private static void print() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			min = data[N - 1][i] < min ? data[N - 1][i] : min; 
		}
		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
