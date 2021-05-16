package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14002 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int[] data = Arrays.stream(in.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		int[] DP = new int[N];
		List<Integer>[] list = new List[N];
		List<Integer> answer = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			DP[i] = 1;
			list[i] = new LinkedList<>();
			for(int j = 0; j < i; j++) {
				if(data[j] < data[i] && DP[i] < DP[j] + 1) {
					DP[i] = DP[j] + 1;
					list[i] = new LinkedList(list[j]);
				}
			}		
			list[i].add(data[i]);
			
			answer = answer.size() > list[i].size() ? answer : list[i];
		}
		ot.write(answer.size() + "\n");
		for(int i = 0, end = answer.size(); i < end; i++) {
			ot.write(answer.get(i) + " ");
		}
		ot.flush();
		ot.close();
	}

}
