package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, X, answer;
	static int[][] map;

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void changeRandC() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int temp = map[i][j];
				map[i][j] = map[j][i];
				map[j][i] = temp;
			}
		}
	}

	private static void implement() {
		next:
		for (int i = 0; i < N; i++) {
			int now = map[i][0];
			boolean[] installed = new boolean[N];
			
			for (int j = 1; j < N; j++) {
				if (map[i][j] == now) continue;
				
				if (map[i][j] + 1 == now) { // ¿À¸¥ÂÊ
					for(int k = 0; k < X; k++) {
						if(j + k >= N || installed[j + k] || map[i][j] != map[i][j + k]) continue next;
						installed[j + k] = true;	
					}
					now = map[i][j];
				} else if (map[i][j] - 1 == now) { // ¿ÞÂÊ
					for(int k = 1; k <= X; k++) {
						if(j - k < 0 || installed[j - k] || map[i][j - 1] != map[i][j - k]) continue next;
						installed[j - k] = true;	
					}
					now = map[i][j];
				} else {
					continue next;
				}

			}
			answer++;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		changeRandC();
		implement();
		System.out.println(answer);
	}

}
