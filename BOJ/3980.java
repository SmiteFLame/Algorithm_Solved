package dongguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3980 {
	static int T, max;
	static int[][] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException {
		max = 0;
		data = new int[11][11];
		for(int i = 0; i < 11; i++) {
			st = new StringTokenizer(io.readLine());
			for(int j = 0; j < 11; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void implement(int idx, int sum, int flag) {
		if(idx == 11) {
			max = sum > max ? sum : max;
			return;
		}
		
		for(int i = 0; i < 11; i++) {
			if((flag & 1 << i) != 0 || data[idx][i] == 0) continue;
			implement(idx + 1, sum + data[idx][i], flag | 1 << i);
		}
	}
	
	private static void print() {
		System.out.println(max);
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(io.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			init();
			implement(0, 0, 0);
			print();
		}

	}

}
