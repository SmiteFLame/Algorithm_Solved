package ssaft.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_5567 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int answer = 0;
		
		ArrayList<Integer>[] friendList = new ArrayList[N + 1];
//		Arrays.fill(friendList, new ArrayList<>());
		for(int i = 1; i <= N; i++) {
			friendList[i] = new ArrayList<>();
		}

		
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			friendList[first].add(second);
			friendList[second].add(first);
		}

		ArrayList<Integer> firstFriend = new ArrayList<>();
		
		for(Integer first : friendList[1]) {
			firstFriend.add(first);
			visited[first] = true;
		}
		
		answer += firstFriend.size();

		for(int i = 0, end = firstFriend.size(); i < end; i++) {
			for(Integer second: friendList[firstFriend.get(i)]) {
				if(visited[second]) continue;
				visited[second] = true;
				answer++;
			}
		}
		
		
		System.out.println(answer);
	}

}
