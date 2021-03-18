package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, cnt;
	static int[] god;
	static int[] rank;

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		god = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			god[i] = i;
		}
	}

	private static int find(int a) {
		if (god[a] == a)
			return a;
		return god[a] = find(god[a]);
	}

	private static void union(int a, int b) {
		int aGod = find(a);
		int bGod = find(b);
		if (aGod == bGod)
			return;
		if (rank[aGod] < rank[bGod]) {
			god[aGod] = bGod;
		}else if(rank[aGod] > rank[bGod]) {
			god[bGod] = aGod;
		}else{
			god[aGod] = bGod;
			rank[bGod]++;
		}
	}

	private static void implement() throws IOException {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= N; i++) {
			if(god[i] == i) cnt++;
		}
	}

	private static void print() {
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
