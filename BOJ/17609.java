package ssafy_study_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_17609 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static String str;

	private static int check(String now, boolean first) {
		int left = 0, right = now.length() - 1;
		while (left <= right) {
			if (now.charAt(left) == now.charAt(right)) {
				left++;
				right--;
			} else {
				if (first && (check(now.substring(left + 1, right + 1), false) == 0
						|| check(now.substring(left, right), false) == 0)) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			str = in.readLine();
			ot.write(check(str, true) + "\n");
		}
		ot.flush();
		ot.close();
	}

}
