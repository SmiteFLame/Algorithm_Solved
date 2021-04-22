package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K, pointA, pointB, cnt, answer;
	static int[] data;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		pointA = N - 1;
		pointB = 2 * N - 1;

		data = new int[N * 2];
		robot = new boolean[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0, end = N * 2; i < end; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			// 컨테이너 이동
			int temp = data[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) {
				data[i] = data[i - 1];
			}
			data[0] = temp;

			// 로봇 회전
			for (int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			
			// 로봇 이동
			robot[0] = false;
			robot[N - 1] = false;
			for (int i = N - 1; i > 0; i--) { 
				if (robot[i - 1] && !robot[i] && data[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					data[i]--;
				}
			}
			
			// 로봇 올리기
			if(data[0] > 0) {
				robot[0] = true;
				data[0]--;
			}
			
			answer++;

			int cnt = 0;
			for (int i = 0; i < N * 2; i++) {
				if (data[i] <= 0)
					cnt++;
			}
			
			if (cnt >= K)
				break;
		}
		System.out.println(answer);
	}
}
