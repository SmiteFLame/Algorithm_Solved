package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2116 {
	static int N, max = 0;
	static int[][] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException{
		N = Integer.parseInt(io.readLine());
		
		data = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = Integer.parseInt(st.nextToken());
			data[i][4] = Integer.parseInt(st.nextToken());
			data[i][5] = Integer.parseInt(st.nextToken());
			data[i][3] = Integer.parseInt(st.nextToken());			
		}
	}
	
//	사용 불가능한면, 사용한 번호
	
	private static void implement() {
		for(int i = 0; i < 6; i++) {
			int sum = 0;
			int nowUp = i;
			for(int j = 0; j < N; j++) {
				
				int lineMax = 0;
				for(int k = 0; k < 6; k++) {
					if((k % 3) == (nowUp % 3)) continue;
					lineMax = data[j][k] > lineMax ? data[j][k] : lineMax;
				}
				sum += lineMax;
				
				if(j == N - 1) break;
				
				for(int k = 0; k < 6; k++) {
					if(data[j + 1][k] == data[j][nowUp]) {
						nowUp = k;
						break;
					}
				}
				nowUp = nowUp >= 3 ? nowUp - 3 : nowUp + 3;
			}
			max = sum > max ? sum : max;
		}
	}
	
	private static void print() {
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}

}
