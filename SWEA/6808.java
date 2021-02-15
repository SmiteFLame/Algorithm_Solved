package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_6808_¾çµ¿Çõ {
	static int T, winQ, winI;
	static LinkedList<Integer> cardQ = new LinkedList<>();
	static LinkedList<Integer> cardI = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());

		cardQ.clear();
		cardI.clear();
		
		winQ = 0;
		winI = 0;

		for (int i = 0; i < 9; i++) {
			cardQ.offer(Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= 18; i++) {
			if (cardQ.contains(i))
				continue;
			cardI.offer(i);
		}
	}

	private static void implement(int cnt, int flag, int sumQ, int sumI) {
		if (cnt == 9) {
			if (sumQ > sumI)
				winQ++;
			else if (sumI > sumQ)
				winI++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			if (cardQ.get(cnt) < cardI.get(i)) {
				implement(cnt + 1, flag | 1 << i, sumQ, sumI + cardQ.get(cnt) + cardI.get(i));
			} else {
				implement(cnt + 1, flag | 1 << i, sumQ + cardQ.get(cnt) + cardI.get(i), sumI);
			}
		}
	}

	private static void print(int test_case) {
		sb.append("#").append(test_case).append(" ").append(winQ).append(" ").append(winI).append("\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(io.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			implement(0, 0, 0, 0);
			print(test_case);
		}
		System.out.println(sb.toString());
	}
}
