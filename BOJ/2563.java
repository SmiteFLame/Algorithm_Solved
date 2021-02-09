package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2563_양동혁 {
	static int N, X, Y, answer = 0;
	static boolean[][] map;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		
		// 최대 넓이가 100 * 100 이므로 미리 정의한다.
		map = new boolean[100][100];
	}

	private static void implement() throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			// 입력 받은 값으로 부터 10 *10 map에 데이터를 추가한다
			
			// 최대 범위를 넘어가지 않도록 Math.min(100, X + 10)를 통해서 값의 범위를 지정해 준다.
			for (int k = X, endK = Math.min(100, X + 10); k < endK; k++) {
				for (int l = Y, endL = Math.min(100, Y + 10); l < endL; l++) {
					
					// map에서 올려지지 칠해지지 않은 값만 구하고 넓이를 추가한다
					// 칠해진 구역은 true로 바꾼다.
					if(!map[k][l]) {
						answer++;
						map[k][l] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		System.out.println(answer);
	}
}
