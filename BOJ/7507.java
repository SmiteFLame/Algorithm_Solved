package ssafy.study.week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7507 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	// 경기 시작시간, 종료시간
	static int N;
	static int answer;
	static Time[] time;

	static class Time implements Comparable<Time> {
		int day;
		int start;
		int end;

		Time(int day, int start, int end) {
			this.day = day;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if (this.day == o.day)
				return this.end == o.end ? this.start - o.start : this.end - o.end;
			else
				return this.day - o.day;
		}

	}

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		answer = 1;
		time = new Time[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(time);
	}

	private static void implement() {
		int nowDay = time[0].day;
		int endTime = time[0].end;
		for (int i = 0; i < N; i++) {
			if (nowDay < time[i].day || endTime <= time[i].start) {
				answer++;
				nowDay = time[i].day;
				endTime = time[i].end;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init();
			implement();
			ot.write("Scenario #" + tc + ":\n");
			ot.write(answer + "\n\n");
		}
		ot.flush();
		ot.close();
	}
}
