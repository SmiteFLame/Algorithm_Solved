package ssaft.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, max;
	static int[][] data;
	
	static int[] order;
	
	private static int nextPlayer(int X) {
		return X == 8 ? 0 : X + 1;
	}
	
	private static int simulation() {
		int nowPlayer = 0;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int outCount = 0 ;
			int field = 0;
			while(outCount < 3) {
				if(data[i][order[nowPlayer]] == 0) {
					outCount++;
				} else {
					// base에 추가
					field++;
					
					// N루타 마다 이동
					for(int j = 0, end = data[i][order[nowPlayer]]; j < end; j++) {
						field <<= 1;
						if(field >= 16) {
							field -= 16;
							answer++;
						}
					}					
				}
				
				nowPlayer = nextPlayer(nowPlayer);
			}
		}
		
		return answer;
	}
	
	
	private static void subset(int idx, int flag) {
		if(idx == 3) {
			subset(idx + 1, flag);
			return;
		}
		
		if(idx == 9) {
			int answer = simulation();
			max = answer > max ? answer : max;
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if((flag & (1 << i)) != 0) continue;
			order[idx] = i;
			subset(idx + 1, flag | (1 << i));
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		// init
		N = Integer.parseInt(in.readLine());
		data = new int[N][9];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 9; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//implement
		order = new int[9];
		
		// 4번타자 고정석
		order[3] = 0;
		subset(0, 1);
		
		// print
		System.out.println(max);
	}

}
