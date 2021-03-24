package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_양동혁 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static double E, answer;
	static int[] parents;
	static int[][] data;
	static PriorityQueue<Edge> pQueue;

	// 간선을 저장하는 Class
	static class Edge implements Comparable<Edge> {
		double weight;
		int start;
		int end;

		Edge(double weight, int start, int end) {
			this.weight = weight;
			this.start = start;
			this.end = end;
		}

		// 우선 순위 Q를 사용하기 위해서 간선 크기가 작은 순서대로 정렬할 수 있도록 비교함수 설정
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	// 두 점사이의 환경 부담금
	private static double enviromentCost(int[] X, int[] Y) {
		return E * (Math.pow(Math.abs(X[1] - Y[1]), 2) + Math.pow(Math.abs(X[0] - Y[0]), 2));
	}

	// 두 개의 섬을 합치기
	private static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		if (parentX == parentY)
			return false;
		parents[parentX] = parentY;
		return true;
	}

	// 섬의 부모 찾기
	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	// 데이터 정리
	private static void init() throws IOException {
		// 전체 데이터를 초기화
		N = Integer.parseInt(in.readLine());
		data = new int[N][2];
		parents = new int[N];
		pQueue = new PriorityQueue<>();
		answer = 0;
		
		// X좌표와 Y좌표값 받기, 환경 부담 세율 실수 E 받기
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			data[i][0] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		E = Double.parseDouble(in.readLine());
		
		// 모든 간선에 대하여 우선순위 Q에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				pQueue.offer(new Edge(enviromentCost(data[i], data[j]), i, j));
			}
		}

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static void implement() {
		int cnt = 0;
		
		// N - 1개의 간선 추출하기
		while (cnt < N - 1) {
			Edge now = pQueue.poll();
			
			// 만약 이미 같은 부모라면 continue
			if (!union(now.start, now.end))
				continue;
			
			// 현재 간선 값을 합치기
			answer += now.weight;
			cnt++;
		}
	}

	private static void print(int tc) throws IOException {
		// answer를 반올림 한 후 출력
		ot.write("#" + tc + " " + Math.round(answer) + "\n");
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init();
			implement();
			print(tc);
		}
		ot.flush();
		ot.close();
	}

}
