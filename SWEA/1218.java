package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_¾çµ¿Çõ {
	static int T = 10, N;
	static boolean canTrue;
	static String data;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int test_case = 1; test_case <= T; test_case++) {
			stack.clear();
			canTrue = true;

			N = Integer.parseInt(in.readLine());
			data = in.readLine();

			for (int i = 0; i < N; i++) {
				if (data.charAt(i) == '{' || data.charAt(i) == '<' || data.charAt(i) == '(' || data.charAt(i) == '[') {
					stack.add(data.charAt(i));
				} else {
					if (stack.isEmpty()) {
					} else if (data.charAt(i) == '}' && stack.pop() == '{') {
						continue;
					} else if (data.charAt(i) == '>' && stack.pop() == '<') {
						continue;
					} else if (data.charAt(i) == ')' && stack.pop() == '(') {
						continue;
					} else if (data.charAt(i) == ']' && stack.pop() == '[') {
						continue;
					}
					canTrue = false;
					break;
				}
			}

			sb.append("#" + test_case + " ");

			if (canTrue)
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}

		System.out.println(sb.toString());
	}
}
