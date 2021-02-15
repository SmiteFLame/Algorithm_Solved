package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G4_1062_°¡¸£Ä§ {
	static int N, K, max;
	static String[] data;
	static char[] stack;
	static LinkedList<Character> alpabet = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {

		String[] basic = { "a", "n", "t", "i", "c" };

		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new String[N];

		for (int i = 0; i < N; i++) {
			data[i] = io.readLine();

			for (int j = 0; j < 5; j++) {
				data[i] = data[i].replaceAll(basic[j], "");
			}

			for (int j = 0, end = data[i].length(); j < end; j++) {
				if (alpabet.contains(data[i].charAt(j)))
					continue;

				alpabet.add(data[i].charAt(j));
			}
		}

	}

	private static void implement() {
		if (K < 5)
			return;
		stack = new char[K - 5];
		combination(0, 0);
	}

	private static void combination(int idx, int cnt) {
		if (cnt == K - 5 || cnt == alpabet.size()) {
			int countString = 0;
			for (String s : data) {
				boolean check = true;
				checking: for (int i = 0, end = s.length(); i < end; i++) {
					for (int j = 0; j < cnt; j++) {
						if (stack[j] == s.charAt(i))
							continue checking;
					}
					check = false;
					break checking;
				}
				if (check)
					countString++;
			}
			max = countString > max ? countString : max;
			return;
		}
		if (idx < alpabet.size())

		{
			combination(idx + 1, cnt);
			stack[cnt] = alpabet.get(idx);
			combination(idx + 1, cnt + 1);
		}
	}

	private static void print() {
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
