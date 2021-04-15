package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15961 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, d, k, c, answer;
	static int[] sushi, menu;
	static Set<List<Integer>> set;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N + k];
		
		menu = new int[d + 1];
		
		// 종류 30가지가 있다.
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(in.readLine());
		}
		
		menu[c] = 1;
		
		int cnt = 1;
		
		for(int i = 0; i < k; i++) {
			sushi[N + i] = sushi[i];
			if(menu[sushi[i]] == 0) cnt++;
			menu[sushi[i]]++;
		}
		
		answer = cnt;
		
		
		for(int i = 0; i < N; i++) {
			if(menu[sushi[i + k]] == 0) cnt++;
			menu[sushi[i + k]]++;
			menu[sushi[i]]--;
			if(menu[sushi[i]] == 0) cnt--;
			
			answer = cnt > answer ? cnt : answer;
		}
		
		System.out.println(answer);
	}
}
