package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {
	static int N, sum = 1;
	static int[][] data;
	static int[] count;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException{
		N = Integer.parseInt(io.readLine());
		data = new int[6][2];
		count = new int[5];
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(io.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			count[data[i][0]]++;
		}
	}
	
	private static void implement() {
		int[] X = new int[2];
		boolean[] V = new boolean[2];
		for(int i = 1, idx = 0; i <= 4; i++) {
			if(count[i] == 1) {
				X[idx++] = i;
			}
		}
		sum = 1;
		for(int i = 0; i < 6; i++) {
			if(data[i][0] == X[0] && !V[0]) {
				sum *= data[i][1];
				X[0] = i;
				V[0] = true;
			} else if(data[i][0] == X[1]&& !V[1]) {
				sum *= data[i][1];
				X[1] = i;
				V[1] = true;
			}
		}
		X[0] = X[0] >= 3 ? X[0] - 3 : X[0] + 3;
		X[1] = X[1] >= 3 ? X[1] - 3 : X[1] + 3;
		sum -= (data[X[0]][1] * data[X[1]][1]);
	}
	
	private static void print() {
		System.out.println(sum * N);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}
}
