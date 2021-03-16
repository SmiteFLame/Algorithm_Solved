package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int L, C;
	static char[] data;
	static final ArrayList<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[C];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) {
			data[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(data);
	}

	private static void backTracking(int idx, String str, int vowelCnt, int consonantCnt) throws IOException {
		if (str.length() == L) {
			if (vowelCnt >= 1 && consonantCnt >= 2)
				ot.write(str + "\n");
			return;
		}

		if (idx == C)
			return;

		if (vowel.contains(data[idx]))
			backTracking(idx + 1, str + data[idx], vowelCnt + 1, consonantCnt);
		else
			backTracking(idx + 1, str + data[idx], vowelCnt, consonantCnt + 1);

		backTracking(idx + 1, str, vowelCnt, consonantCnt);

	}

	private static void implement() throws IOException {
		backTracking(0, "", 0, 0);
	}

	private static void print() throws IOException {
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
