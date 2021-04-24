package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1004 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(in.readLine());
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				boolean check = false;
				if (Math.pow(startX - X, 2) + Math.pow(startY - Y, 2) < Math.pow(C, 2)) {
					check = !check;
				}
				if (Math.pow(endX - X, 2) + Math.pow(endY - Y, 2) < Math.pow(C, 2)) {
					check = !check;
				}
				if (check)
					cnt++;
			}
			System.out.println(cnt);
		}
	}

}
