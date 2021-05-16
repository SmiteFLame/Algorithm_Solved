package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class BOJ_15666 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M;
	static int[] answer;
	static List<Integer> list;
	
	private static void subset(int idx, int cnt) throws IOException{
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				ot.write(answer[i] + " ");
			}
			ot.write("\n");
			return;
		}
		if(idx == list.size()) {
			return;
		}
		answer[cnt] = list.get(idx);
		subset(idx, cnt + 1);
		subset(idx + 1, cnt);
	}
	
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		
		Set<Integer> set = new HashSet<>();		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList(set);
		Collections.sort(list);
		subset(0, 0);
		
		ot.flush();
		ot.close();
		
	}

}
