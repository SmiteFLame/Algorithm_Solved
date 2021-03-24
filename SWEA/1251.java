package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_�絿�� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static double E, answer;
	static int[] parents;
	static int[][] data;
	static PriorityQueue<Edge> pQueue;

	// ������ �����ϴ� Class
	static class Edge implements Comparable<Edge> {
		double weight;
		int start;
		int end;

		Edge(double weight, int start, int end) {
			this.weight = weight;
			this.start = start;
			this.end = end;
		}

		// �켱 ���� Q�� ����ϱ� ���ؼ� ���� ũ�Ⱑ ���� ������� ������ �� �ֵ��� ���Լ� ����
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	// �� �������� ȯ�� �δ��
	private static double enviromentCost(int[] X, int[] Y) {
		return E * (Math.pow(Math.abs(X[1] - Y[1]), 2) + Math.pow(Math.abs(X[0] - Y[0]), 2));
	}

	// �� ���� ���� ��ġ��
	private static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		if (parentX == parentY)
			return false;
		parents[parentX] = parentY;
		return true;
	}

	// ���� �θ� ã��
	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	// ������ ����
	private static void init() throws IOException {
		// ��ü �����͸� �ʱ�ȭ
		N = Integer.parseInt(in.readLine());
		data = new int[N][2];
		parents = new int[N];
		pQueue = new PriorityQueue<>();
		answer = 0;
		
		// X��ǥ�� Y��ǥ�� �ޱ�, ȯ�� �δ� ���� �Ǽ� E �ޱ�
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			data[i][0] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		E = Double.parseDouble(in.readLine());
		
		// ��� ������ ���Ͽ� �켱���� Q�� �ֱ�
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
		
		// N - 1���� ���� �����ϱ�
		while (cnt < N - 1) {
			Edge now = pQueue.poll();
			
			// ���� �̹� ���� �θ��� continue
			if (!union(now.start, now.end))
				continue;
			
			// ���� ���� ���� ��ġ��
			answer += now.weight;
			cnt++;
		}
	}

	private static void print(int tc) throws IOException {
		// answer�� �ݿø� �� �� ���
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
