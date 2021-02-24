package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578 {
	
	static class pair{
		public int X, Y;
		pair(int X, int Y){
			this.X = X;
			this.Y = Y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		pair[] data = new pair[26];
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(io.readLine());
			for(int j = 0; j < 5; j++) {
				data[Integer.parseInt(st.nextToken())] = new pair(i, j);
			}			
		}
		int hor[], ver[], LtoR = 0, RtoL = 0, ans = 0;
		int cnt = 0;
		hor = new int[5];
		ver = new int[5];
		boolean find = false;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(io.readLine());
			if(find) continue;
			for(int j = 0; j < 5; j++) {
				int X = Integer.parseInt(st.nextToken());
				hor[data[X].Y]++;
				if(hor[data[X].Y] == 5) {
					cnt++;
				}
				ver[data[X].X]++;
				if(ver[data[X].X] == 5) {
					cnt++;
				}
				if(data[X].X == data[X].Y) {
					LtoR++;
					if(LtoR == 5) {
						cnt++;
					}
				}
				if(data[X].X + data[X].Y == 4) {
					RtoL++;
					if(RtoL == 5) {
						cnt++;
					}
				}
				if(cnt >= 3) {
					find = true;
					ans = i * 5 + j + 1;
					break;
				}
			}			
		}
		System.out.println(ans);
	}
}
